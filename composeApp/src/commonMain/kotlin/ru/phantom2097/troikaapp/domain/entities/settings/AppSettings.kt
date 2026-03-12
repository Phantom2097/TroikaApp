package ru.phantom2097.troikaapp.domain.entities.settings

data class AppSettings(
    val theme: AppTheme = AppTheme.SYSTEM,
    val language: Language = Language.SYSTEM,
    val notifications: Boolean = true,
)