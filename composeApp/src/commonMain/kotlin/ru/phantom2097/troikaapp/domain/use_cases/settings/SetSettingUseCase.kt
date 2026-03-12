package ru.phantom2097.troikaapp.domain.use_cases.settings

import ru.phantom2097.troikaapp.domain.entities.settings.AppTheme
import ru.phantom2097.troikaapp.domain.entities.settings.Language
import ru.phantom2097.troikaapp.domain.entities.settings.SettingsRepository

class SetSettingUseCase(
    private val repository: SettingsRepository,
) {

    suspend fun setTheme(theme: AppTheme) {
        repository.setTheme(theme)
    }

    suspend fun setLanguage(language: Language) {
        repository.setLanguage(language)
    }

    suspend fun setNotifications(notifications: Boolean) {
        repository.setNotifications(notifications)
    }
}