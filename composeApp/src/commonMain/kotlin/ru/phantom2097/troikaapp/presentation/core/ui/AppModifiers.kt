package ru.phantom2097.troikaapp.presentation.core.ui

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.layout

object AppModifiers {
    private const val COLLAPSE_AND_CLIP_MIN_HEIGHT = 0
    private const val COLLAPSE_AND_CLIP_DEFAULT_X_LINE_SET = 0

    fun Modifier.collapseAndClip(squishProvider: () -> Int): Modifier = this
        .clipToBounds()
        .layout { measurable, constraints ->
            val placeable = measurable.measure(constraints)

            val squishPx = squishProvider()

            val currentHeight = maxOf(COLLAPSE_AND_CLIP_MIN_HEIGHT, placeable.height - squishPx)

            layout(placeable.width, currentHeight) {
                placeable.placeRelative(COLLAPSE_AND_CLIP_DEFAULT_X_LINE_SET, -squishPx)
            }
        }
}