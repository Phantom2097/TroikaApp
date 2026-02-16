package ru.phantom2097.troikaapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSerializable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberDecoratedNavEntries
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.savedstate.compose.serialization.serializers.MutableStateSerializer
import androidx.savedstate.serialization.SavedStateConfiguration
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import ru.phantom2097.troikaapp.navigation.AppRoutes.HistoryRoute
import ru.phantom2097.troikaapp.navigation.AppRoutes.SettingsRoute
import ru.phantom2097.troikaapp.navigation.AppRoutes.SubscriptionRoute
import ru.phantom2097.troikaapp.navigation.AppRoutes.SummaryRoute

class NavigationState(
    val startRoute: NavKey,
    topLevelRoute: MutableState<NavKey>,
    val backStacks: Map<NavKey, NavBackStack<NavKey>>,
) {
    var topLevelRoute by topLevelRoute

    val stacksInUse: List<NavKey>
        get() = if (topLevelRoute == startRoute) {
            listOf(startRoute)
        } else {
            listOf(startRoute, topLevelRoute)
        }
}

@Composable
fun rememberNavigationState(
    startRoute: NavKey,
    topLevelRoutes: Set<NavKey>,
): NavigationState {
    val topLevelRoute = rememberSerializable(
        startRoute, topLevelRoutes, configuration = serializersConfig,
        serializer = MutableStateSerializer(PolymorphicSerializer(NavKey::class))
    ) {
        mutableStateOf(startRoute)
    }

    val backStacks = topLevelRoutes.associateWith { key ->
        rememberNavBackStack(
            configuration = serializersConfig,
            key
        )
    }

    return remember(
        startRoute, topLevelRoutes
    ) {
        NavigationState(
            startRoute = startRoute,
            topLevelRoute = topLevelRoute,
            backStacks = backStacks
        )
    }
}

private val serializersConfig = SavedStateConfiguration {
    serializersModule = SerializersModule {
        polymorphic(NavKey::class) {
            subclass(SummaryRoute::class, SummaryRoute.serializer())
            subclass(HistoryRoute::class, HistoryRoute.serializer())
            subclass(SettingsRoute::class, SettingsRoute.serializer())
            subclass(SubscriptionRoute::class, SubscriptionRoute.serializer())
            subclass(
                AppRoutes.SelectTargetPeriodRoute::class,
                AppRoutes.SelectTargetPeriodRoute.serializer()
            )
        }
    }
}

@Composable
fun NavigationState.toEntries(
    entryProvider: (NavKey) -> NavEntry<NavKey>,
): SnapshotStateList<NavEntry<NavKey>> {
    val decoratedEntries = backStacks.mapValues { (_, stack) ->
        val decorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator<NavKey>()
        )

        rememberDecoratedNavEntries(
            backStack = stack,
            entryDecorators = decorators,
            entryProvider = entryProvider
        )
    }

    return stacksInUse
        .flatMap { decoratedEntries[it] ?: emptyList() }
        .toMutableStateList()
}