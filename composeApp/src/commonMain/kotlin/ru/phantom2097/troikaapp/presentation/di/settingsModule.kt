package ru.phantom2097.troikaapp.presentation.di

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import ru.phantom2097.troikaapp.presentation.settings.SettingsViewModel

val settingsModule = module {
    viewModel { SettingsViewModel(get(), get()) }
}