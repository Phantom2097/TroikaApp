package ru.phantom2097.troikaapp.presentation.history

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.phantom2097.troikaapp.presentation.ui.theme.AppTheme

@Composable
fun BarAndLineChart(
    data: List<Float>,
    modifier: Modifier = Modifier,
    barColor: Color = MaterialTheme.colorScheme.primary,
    lineColor: Color = MaterialTheme.colorScheme.tertiary,
) {
    Canvas(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ) {

        val canvasWidth = size.width
        val canvasHeight = size.height
        val maxValue = data.maxOrNull() ?: 1f

        val spaceBetweenBars = 24.dp.toPx()
        val barWidth = (canvasWidth - (spaceBetweenBars * (data.size - 1))) / data.size

        data.forEachIndexed { index, value ->
            val x = index * (barWidth + spaceBetweenBars)
            val barHeight = (value / maxValue) * canvasHeight

            // 1. Рисуем столбик
            drawRect(
                color = barColor,
                topLeft = Offset(x, canvasHeight - barHeight),
                size = Size(barWidth, barHeight),
                style = Stroke(
                    width = 16.dp.toPx(),
                    cap = StrokeCap.Round,
                    pathEffect = PathEffect.cornerPathEffect(100f)
                )
            )
        }
    }
}

@Preview
@Composable
fun BarAndLineChartPreview() {
    AppTheme {
        BarAndLineChart(
            listOf(1f, 0.5f, 1.1f, 1f,)
        )
    }
}