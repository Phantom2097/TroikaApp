package ru.phantom2097.troikaapp.data.repository.settings

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.phantom2097.troikaapp.domain.entities.settings.AppSettings
import ru.phantom2097.troikaapp.domain.entities.settings.AppTheme
import ru.phantom2097.troikaapp.domain.entities.settings.Language
import ru.phantom2097.troikaapp.domain.entities.settings.SettingsRepository

class SettingsRepositoryImpl(
    private val dataStore: DataStore<Preferences>,
) : SettingsRepository {
    override fun getSettings(): Flow<AppSettings> {
        val settingsFlow = dataStore.data.map { preferences ->
            AppSettings(
                theme = AppTheme.fromString(
                    preferences[SettingsPreferencesKeys.THEME] ?: AppTheme.defaultValue.name
                ),
                language = Language.fromString(
                    preferences[SettingsPreferencesKeys.LANGUAGE] ?: Language.defaultValue.name
                ),
                notifications = preferences[SettingsPreferencesKeys.NOTIFICATIONS] ?: true
            )
        }

        return settingsFlow
    }

    override suspend fun setTheme(theme: AppTheme) {
        dataStore.edit {
            it[SettingsPreferencesKeys.THEME] = theme.name
        }
    }

    override suspend fun setLanguage(language: Language) {
        dataStore.edit {
            it[SettingsPreferencesKeys.LANGUAGE] = language.name
        }
    }

    override suspend fun setNotifications(notifications: Boolean) {
        dataStore.edit {
            it[SettingsPreferencesKeys.NOTIFICATIONS] = notifications
        }
    }

    private object SettingsPreferencesKeys {
        val THEME = stringPreferencesKey("app_theme_key_v1")
        val LANGUAGE = stringPreferencesKey("app_language_key_v1")
        val NOTIFICATIONS = booleanPreferencesKey("notifications_key_v1")

        val FORMATTED_DATES_TYPE = stringPreferencesKey("formatted_dates_type_key_v1")
        val DATE_SEPARATOR_TYPE = stringPreferencesKey("date_separator_type_key_v1")

        val DATE_RANGE_FIRST_DATE_KEY = stringPreferencesKey("date_range_first_date_key_v1")
        val DATE_RANGE_START_KEY = stringPreferencesKey("date_range_start_key_v1")
        val DATE_RANGE_END_KEY = stringPreferencesKey("date_range_end_key_v1")
    }
}