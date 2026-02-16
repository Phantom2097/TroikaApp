package ru.phantom2097.troikaapp.presentation.core

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun RoundedBoxText(text: Double) {
    Text(
        modifier = Modifier
            .padding(4.dp)
            .clip(
                RoundedCornerShape(8.dp)
            )
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .padding(4.dp),
        text = "$text р",
        color = MaterialTheme.colorScheme.onSecondaryContainer,
    )
}

