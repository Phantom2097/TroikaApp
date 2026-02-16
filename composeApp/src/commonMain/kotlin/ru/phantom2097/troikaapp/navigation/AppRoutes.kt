package ru.phantom2097.troikaapp.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable
import ru.phantom2097.troikaapp.presentation.core.bottom_bar.AppTabs

sealed interface AppRoutes : NavKey {
    @Serializable
    data object SummaryRoute : AppRoutes, NavKey

    @Serializable
    data object SettingsRoute : AppRoutes, NavKey

    @Serializable
    data object SubscriptionRoute : AppRoutes, NavKey

    @Serializable
    data object HistoryRoute : AppRoutes, NavKey

    @Serializable
    data object SelectTargetPeriodRoute : AppRoutes, NavKey
    companion object {
        val TOP_LEVEL_DESTINATIONS = mapOf(
            SummaryRoute to AppTabs.Summary,
            HistoryRoute to AppTabs.History,
            SubscriptionRoute to AppTabs.Subscription,
            SettingsRoute to AppTabs.Settings
        )
    }
}