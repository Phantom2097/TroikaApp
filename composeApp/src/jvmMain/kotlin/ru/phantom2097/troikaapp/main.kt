package ru.phantom2097.troikaapp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import ru.phantom2097.troikaapp.di.initKoin
import ru.phantom2097.troikaapp.presentation.App
import java.awt.Dimension

fun main() = application {
    initKoin()

    val windowState = rememberWindowState()

    Window(
        state = windowState,
        onCloseRequest = ::exitApplication,
        title = "TroikaApp",
    ) {
        window.minimumSize = Dimension(400, 500)
        App()
    }
}