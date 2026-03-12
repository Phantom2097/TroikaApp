package ru.phantom2097.troikaapp.presentation.history.charts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.phantom2097.troikaapp.presentation.ui.theme.AppTheme

private val demoChartValues = listOf(0.2f, 0.3f, 0.4f, 0.6f, 0.9f, 0.7f, 0.4f, 0.2f, 0.3f, 0.1f)

@Composable
fun DemoLineChart(
    contentColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surfaceContainerLow)
            .padding(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .height(150.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            demoChartValues.forEach {
                LineItem(
                    value = it,
                    color = contentColor
                )
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "График поездок",
            color = contentColor
        )
    }
}

@Preview
@Composable
fun DemoLineChartPreview() {
    AppTheme {
        DemoLineChart()
    }
}