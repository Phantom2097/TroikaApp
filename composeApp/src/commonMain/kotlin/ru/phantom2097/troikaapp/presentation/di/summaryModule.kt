package ru.phantom2097.troikaapp.presentation.di

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import ru.phantom2097.troikaapp.presentation.core.app_events.model.AppBottomBarEventBus
import ru.phantom2097.troikaapp.presentation.core.app_events.impl.AppBottomBarEventBusImpl
import ru.phantom2097.troikaapp.presentation.summary.SummaryViewModel

val summaryModule = module {
    viewModel {
        SummaryViewModel(
            get(),
            get(),
            get()
        )
    }

    single<AppBottomBarEventBus> { AppBottomBarEventBusImpl() }
}