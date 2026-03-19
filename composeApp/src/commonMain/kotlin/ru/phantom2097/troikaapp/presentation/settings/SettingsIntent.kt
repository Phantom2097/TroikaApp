package ru.phantom2097.troikaapp.presentation.settings

import ru.phantom2097.troikaapp.domain.entities.settings.AppTheme
import ru.phantom2097.troikaapp.domain.entities.settings.Language

interface SettingsIntent {
    data class ChangeTheme(val theme: AppTheme) : SettingsIntent
    data class ChangeLanguage(val language: Language) : SettingsIntent
    data class ChangeNotifications(val enabled: Boolean) : SettingsIntent
}