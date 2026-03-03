package ru.phantom2097.troikaapp.presentation.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SettingsBlockHeader(
    modifier: Modifier = Modifier,
    text: String
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    0.0f to MaterialTheme.colorScheme.background,
                    1.0f to Color.Transparent
                )
            )
            .padding(horizontal = 16.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.primaryContainer)
                .padding(8.dp),
            text = text,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            fontSize = MaterialTheme.typography.titleMedium.fontSize,
            fontStyle = MaterialTheme.typography.titleMedium.fontStyle
        )
    }
}