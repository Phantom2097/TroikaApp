package ru.phantom2097.troikaapp.presentation

import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import kotlinx.coroutines.launch
import org.koin.compose.koinInject
import ru.phantom2097.troikaapp.navigation.AppRoutes
import ru.phantom2097.troikaapp.navigation.AppRoutes.HistoryRoute
import ru.phantom2097.troikaapp.navigation.AppRoutes.SelectTargetPeriodRoute
import ru.phantom2097.troikaapp.navigation.AppRoutes.SettingsRoute
import ru.phantom2097.troikaapp.navigation.AppRoutes.SubscriptionRoute
import ru.phantom2097.troikaapp.navigation.AppRoutes.SummaryRoute
import ru.phantom2097.troikaapp.navigation.Navigator
import ru.phantom2097.troikaapp.navigation.rememberNavigationState
import ru.phantom2097.troikaapp.navigation.toEntries
import ru.phantom2097.troikaapp.presentation.core.TopAppBarItem
import ru.phantom2097.troikaapp.presentation.core.app_events.NavEvent
import ru.phantom2097.troikaapp.presentation.core.app_events.model.AppBottomBarEventBus
import ru.phantom2097.troikaapp.presentation.core.bottom_bar.BottomAppBarItem
import ru.phantom2097.troikaapp.presentation.history.HistoryScreen
import ru.phantom2097.troikaapp.presentation.settings.SettingsScreen
import ru.phantom2097.troikaapp.presentation.subscription.SubscriptionScreen
import ru.phantom2097.troikaapp.presentation.summary.SummaryScreen
import ru.phantom2097.troikaapp.presentation.summary.select_date.SelectTargetPeriod
import ru.phantom2097.troikaapp.presentation.ui.theme.AppTheme


@OptIn(ExperimentalMaterial3ExpressiveApi::class, ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun App() {

    val navigationState = rememberNavigationState(
        startRoute = SummaryRoute,
        topLevelRoutes = AppRoutes.TOP_LEVEL_DESTINATIONS.keys
    )

    val navigator = remember {
        Navigator(
            state = navigationState
        )
    }

    val eventBus: AppBottomBarEventBus = koinInject()
    val scope = rememberCoroutineScope()

    AppTheme {
        Scaffold(
            topBar = {
                TopAppBarItem(
                    settingsClickListener = {
                        navigator.navigate(SettingsRoute)
                    }
                )
            },
            bottomBar = {
                // TODO: extract into another file
                BottomAppBarItem(
                    selectedKey = navigationState.topLevelRoute
                ) { key ->
                    when (key) {
                        SummaryRoute -> {
                            if (navigationState.topLevelRoute == key) {
                                scope.launch {
                                    eventBus.emit(NavEvent.SummaryReselected)
                                }
                            } else {
                                navigator.goBack()
                            }
                        }

                        HistoryRoute -> {
                            navigator.navigate(HistoryRoute)
                        }

                        SubscriptionRoute -> {
                            navigator.navigate(SubscriptionRoute)
                        }

                        SettingsRoute -> {
                            navigator.navigate(SettingsRoute)
                        }
                    }
                }
            }
        ) { innerPadding ->
            NavDisplay(
                modifier = Modifier,
                onBack = navigator::goBack,
                entries = navigationState.toEntries(
                    entryProvider {
                        entry<SummaryRoute> {
                            SummaryScreen(
                                innerPadding = innerPadding,
                                datePicker = {
                                    navigator.navigate(SelectTargetPeriodRoute)
                                },
                                navToHistoryScreen = {
                                    navigator.navigate(HistoryRoute)
                                }
                            )
                        }
                        entry<HistoryRoute> {
                            HistoryScreen()
                        }
                        entry<SettingsRoute> {
                            SettingsScreen(
                                innerPadding = innerPadding
                            )
                        }
                        entry<SubscriptionRoute> {
                            SubscriptionScreen()
                        }
                        entry<SelectTargetPeriodRoute> {
                            SelectTargetPeriod(
                                onDismissRequest = {
                                    navigator.goBack()
                                }
                            )
                        }
                    }
                ),
            )
        }
    }
}