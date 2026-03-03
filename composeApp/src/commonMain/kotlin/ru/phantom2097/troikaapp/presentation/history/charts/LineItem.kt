package ru.phantom2097.troikaapp.presentation.history.charts

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun LineItem(
    value: Float,
    barWidth: Dp = 20.dp,
    color: Color = Color.Unspecified,
    cornerRadius: CornerRadius = CornerRadius(20f, 20f),
) {
    Canvas(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxHeight()
            .width(barWidth)

    ) {
        val canvasHeight = size.height
        val canvasWidth = size.width

        val barHeightPx = canvasHeight * value
        drawRoundRect(
            color = color,
            topLeft = Offset(x = 0f, y = canvasHeight - barHeightPx),
            size = Size(canvasWidth, height = barHeightPx),
            cornerRadius = cornerRadius
        )
    }
}

@Preview
@Composable
fun LineItemPreview() {
    Box(
        modifier = Modifier
            .padding(20.dp)
    ) {
        LineItem(
            value = 10f,
        )
    }
}