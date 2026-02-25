package ru.phantom2097.troikaapp.presentation.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEachIndexed
import ru.phantom2097.troikaapp.presentation.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun SettingsSectionContent(
    modifier: Modifier = Modifier,
    settingsItems: List<String>,
) {
    Column(
        modifier = modifier
            .background(color = MaterialTheme.colorScheme.background)
            .fillMaxWidth()
            .clip(shape = MaterialTheme.shapes.extraLarge),
    ) {
        settingsItems.fastForEachIndexed { idx, item ->
            if (idx != 0) {
                Spacer(Modifier.height(4.dp))
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(4.dp))
                    .background(color = MaterialTheme.colorScheme.secondaryContainer)
                    .padding(12.dp)
            ) {
                Text(
                    text = item,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
            }
        }
    }
}

@Preview
@PreviewDynamicColors
@Composable
private fun SettingsSectionContentPreview() {
    AppTheme {
        SettingsSectionContent(
            settingsItems = listOf(
                "Заголовок 1",
                "Заголовок 2",
                "Заголовок 3",
                "Заголовок 4",
                "Заголовок 5",
                "Заголовок 6",
                "Заголовок 7",
                "Заголовок 8",
            )
        )
    }
}
