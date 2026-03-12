package ru.phantom2097.troikaapp.domain.use_cases.settings

import kotlinx.coroutines.flow.Flow
import ru.phantom2097.troikaapp.domain.entities.settings.AppSettings
import ru.phantom2097.troikaapp.domain.entities.settings.SettingsRepository

class GetSettingsUseCase(
    private val repository: SettingsRepository,
) {
    operator fun invoke(): Flow<AppSettings> {
        return repository.getSettings()
    }
}