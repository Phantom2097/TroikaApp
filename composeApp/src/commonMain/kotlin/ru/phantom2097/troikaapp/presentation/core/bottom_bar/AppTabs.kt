package ru.phantom2097.troikaapp.presentation.core.bottom_bar

import androidx.navigation3.runtime.NavKey
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import ru.phantom2097.troikaapp.navigation.AppRoutes
import ru.phantom2097.troikaapp.resources.Res
import ru.phantom2097.troikaapp.resources.clipboard_bold
import ru.phantom2097.troikaapp.resources.clipboard_outline
import ru.phantom2097.troikaapp.resources.history_screen_label
import ru.phantom2097.troikaapp.resources.home_smile_bold
import ru.phantom2097.troikaapp.resources.home_smile_outline
import ru.phantom2097.troikaapp.resources.library_bold
import ru.phantom2097.troikaapp.resources.library_outline
import ru.phantom2097.troikaapp.resources.settings_bold
import ru.phantom2097.troikaapp.resources.settings_outline
import ru.phantom2097.troikaapp.resources.settings_screen_label
import ru.phantom2097.troikaapp.resources.subscriptions_screen_label
import ru.phantom2097.troikaapp.resources.summary_screen_label

enum class AppTabs(
    val label: StringResource,
    val iconBold: DrawableResource,
    val iconOutline: DrawableResource,
    val description: StringResource,
    val route: NavKey,
) {
    Summary(
        label = Res.string.summary_screen_label,
        iconBold = Res.drawable.home_smile_bold,
        iconOutline = Res.drawable.home_smile_outline,
        description = Res.string.summary_screen_label,
        route = AppRoutes.SummaryRoute
    ),
    History(
        Res.string.history_screen_label,
        Res.drawable.library_bold,
        Res.drawable.library_outline,
        description = Res.string.history_screen_label,
        route = AppRoutes.HistoryRoute
    ),
    Subscription(
        Res.string.subscriptions_screen_label,
        Res.drawable.clipboard_bold,
        Res.drawable.clipboard_outline,
        description = Res.string.subscriptions_screen_label,
        route = AppRoutes.SubscriptionRoute
    ),
    Settings(
        Res.string.settings_screen_label,
        Res.drawable.settings_bold,
        Res.drawable.settings_outline,
        description = Res.string.settings_screen_label,
        route = AppRoutes.SettingsRoute
    )
}