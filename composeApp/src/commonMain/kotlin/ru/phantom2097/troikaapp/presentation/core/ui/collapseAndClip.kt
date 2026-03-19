package ru.phantom2097.troikaapp.presentation.core.ui

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.layout

fun Modifier.collapseAndClip(squishProvider: () -> Int): Modifier = this
    .clipToBounds()
    .layout { measurable, constraints ->
        val placeable = measurable.measure(constraints)

        val squishPx = squishProvider()

        val currentHeight = maxOf(0, placeable.height - squishPx)

        layout(placeable.width, currentHeight) {
            placeable.placeRelative(0, -squishPx)
        }
    }