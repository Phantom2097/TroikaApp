package ru.phantom2097.troikaapp.presentation.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.map
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

    val appSettings: StateFlow<SettingsState> = getSettingsUseCase()
        .map { settings ->
            SettingsState.Success(settings)
        }
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5.seconds),
                SettingsState.Loading
            )

    fun onIntent(intent: SettingsIntent) = with(intent) {
        when (this) {
            is SettingsIntent.ChangeTheme -> changeTheme(theme)
            is SettingsIntent.ChangeLanguage -> changeLanguage(language)
            is SettingsIntent.ChangeNotifications -> changeNotifications(enabled)
        }
    }

    private fun changeTheme(theme: AppTheme) {
        viewModelScope.launch(Dispatchers.IO) {
            setSettingUseCase.setTheme(theme)
        }
    }

    private fun changeLanguage(language: Language) {
        viewModelScope.launch {
            setSettingUseCase.setLanguage(language)
        }
    }

    private fun changeNotifications(notifications: Boolean) {
        viewModelScope.launch {
            setSettingUseCase.setNotifications(notifications)
        }
    }
}

sealed interface SettingsState {
    data object Loading : SettingsState
    data class Success(val settings: AppSettings) : SettingsState
}