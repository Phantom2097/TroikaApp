package ru.phantom2097.troikaapp.presentation.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import ru.phantom2097.troikaapp.domain.entities.settings.AppSettings
import ru.phantom2097.troikaapp.domain.entities.settings.AppTheme
import ru.phantom2097.troikaapp.domain.entities.settings.Language
import ru.phantom2097.troikaapp.domain.use_cases.settings.GetSettingsUseCase
import ru.phantom2097.troikaapp.domain.use_cases.settings.SetSettingUseCase
import kotlin.time.Duration.Companion.seconds

// TODO: Use Actions or Events
// TODO: Clean settings screen
// TODO: Use Resources for settings
// TODO: Try theme change more smoothly
class SettingsViewModel(
    private val getSettingsUseCase: GetSettingsUseCase,
    private val setSettingUseCase: SetSettingUseCase
) : ViewModel() {

    val appSettings: StateFlow<AppSettings> = getSettingsUseCase()
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5.seconds),
                AppSettings()
            )

    fun changeTheme(theme: AppTheme) {
        viewModelScope.launch(Dispatchers.IO) {
            setSettingUseCase.setTheme(theme)
        }
    }

    fun changeLanguage(language: Language) {
        viewModelScope.launch {
            setSettingUseCase.setLanguage(language)
        }
    }

    fun changeNotifications(notifications: Boolean) {
        viewModelScope.launch {
            setSettingUseCase.setNotifications(notifications)
        }
    }
}