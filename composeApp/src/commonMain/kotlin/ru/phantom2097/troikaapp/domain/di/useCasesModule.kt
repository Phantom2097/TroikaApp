package ru.phantom2097.troikaapp.domain.di

import org.koin.dsl.module
import ru.phantom2097.troikaapp.domain.entities.settings.SettingsRepository
import ru.phantom2097.troikaapp.domain.use_cases.AddTripInformationUseCase
import ru.phantom2097.troikaapp.domain.use_cases.CalculateBenefitUseCase
import ru.phantom2097.troikaapp.domain.use_cases.ExportTripStatisticsUseCase
import ru.phantom2097.troikaapp.domain.use_cases.settings.GetSettingsUseCase
import ru.phantom2097.troikaapp.domain.use_cases.GetSubscriptionsInfoUseCase
import ru.phantom2097.troikaapp.domain.use_cases.GetTripHistoryUseCase
import ru.phantom2097.troikaapp.domain.use_cases.SelectTargetPeriodUseCase
import ru.phantom2097.troikaapp.domain.use_cases.settings.SetSettingUseCase

val useCasesModule = module {
    factory {
        AddTripInformationUseCase(repository = get())
    }
    factory {
        CalculateBenefitUseCase()
    }
    factory {
        ExportTripStatisticsUseCase(repository = get())
    }

    factory {
        GetSettingsUseCase(repository = get<SettingsRepository>())
    }
    factory {
        SetSettingUseCase(repository = get<SettingsRepository>())
    }

    factory {
        GetSubscriptionsInfoUseCase(repository = get())
    }
    factory {
        GetTripHistoryUseCase(repository = get())
    }
    factory {
        SelectTargetPeriodUseCase()
    }
    //TODO: Create all
}