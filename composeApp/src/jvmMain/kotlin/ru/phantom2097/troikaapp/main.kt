package ru.phantom2097.troikaapp

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import org.koin.compose.viewmodel.koinViewModel
import ru.phantom2097.troikaapp.di.initKoin
import ru.phantom2097.troikaapp.presentation.App
import ru.phantom2097.troikaapp.presentation.settings.SettingsState
import ru.phantom2097.troikaapp.presentation.settings.SettingsViewModel
import java.awt.Dimension

fun main() = application {
    initKoin()

    val viewModelStoreOwner = remember {
        object : ViewModelStoreOwner {
            override val viewModelStore = ViewModelStore()
        }
    }

    CompositionLocalProvider(
        LocalViewModelStoreOwner provides viewModelStoreOwner
    ) {

        val settingsViewModel: SettingsViewModel = koinViewModel()
        val settingsState by settingsViewModel.appSettings.collectAsState()

        when (settingsState) {

            is SettingsState.Loading -> {
                // TODO("Implement splash screen")
            }

            is SettingsState.Success -> {

                Window(
                    onCloseRequest = ::exitApplication,
                    title = "TroikaApp",
                ) {

                    window.minimumSize = Dimension(400, 500)

                    App()
                }
            }
        }
    }
}