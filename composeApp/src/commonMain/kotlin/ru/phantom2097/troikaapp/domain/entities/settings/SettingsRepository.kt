package ru.phantom2097.troikaapp.domain.entities.settings

import kotlinx.coroutines.flow.Flow

interface SettingsRepository {

    fun getSettings(): Flow<AppSettings>

    suspend fun setTheme(theme: AppTheme)
    suspend fun setLanguage(language: Language)
    suspend fun setNotifications(notifications: Boolean)
}