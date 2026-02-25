package ru.phantom2097.troikaapp.presentation.core.bottom_bar

import androidx.navigation3.runtime.NavKey
import org.jetbrains.compose.resources.DrawableResource
import ru.phantom2097.troikaapp.navigation.AppRoutes
import ru.phantom2097.troikaapp.resources.Res
import ru.phantom2097.troikaapp.resources.clipboard_bold
import ru.phantom2097.troikaapp.resources.clipboard_outline
import ru.phantom2097.troikaapp.resources.home_smile_bold
import ru.phantom2097.troikaapp.resources.home_smile_outline
import ru.phantom2097.troikaapp.resources.library_bold
import ru.phantom2097.troikaapp.resources.library_outline
import ru.phantom2097.troikaapp.resources.settings_bold
import ru.phantom2097.troikaapp.resources.settings_outline

enum class AppTabs(
    val label: String,
    val iconBold: DrawableResource,
    val iconOutline: DrawableResource,
    val description: String? = null,
    val route: NavKey,
) {
    Summary(
        "Сводка",
        Res.drawable.home_smile_bold,
        Res.drawable.home_smile_outline,
        "Сводка",
        route = AppRoutes.SummaryRoute
    ),
    History(
        "История",
        Res.drawable.library_bold,
        Res.drawable.library_outline,
        description = null,
        route = AppRoutes.HistoryRoute
    ),
    Subscription(
        "Подписки",
        Res.drawable.clipboard_bold,
        Res.drawable.clipboard_outline,
        null,
        route = AppRoutes.SubscriptionRoute
    ),
    Settings(
        "Настройки",
        Res.drawable.settings_bold,
        Res.drawable.settings_outline,
        null,
        route = AppRoutes.SettingsRoute
    )
}