package ru.phantom2097.troikaapp.presentation.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach

@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    settingsList: List<Pair<String, List<String>>> = settings,
    innerPadding: PaddingValues = PaddingValues(),
) {
    val paddingValues = PaddingValues(
        end = innerPadding.calculateEndPadding(LayoutDirection.Ltr),
        start = innerPadding.calculateStartPadding(LayoutDirection.Ltr),
        bottom = innerPadding.calculateBottomPadding()
    )
    val topPadding = innerPadding.calculateTopPadding()

    LazyColumn(
        modifier = modifier
            .padding(top = topPadding),
        contentPadding = paddingValues
    ) {
        item {
            SettingsIconWithSwitch(
                "Toggle",
                false,
                { }
            )
        }
        item {
            SettingsIconWithMultipleChoose(
                "MultipleChoose",
                initialValue = false,
                { }
            )
        }
        settingsList.fastForEach { (title, item) ->
            stickyHeader {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 4.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(MaterialTheme.colorScheme.primaryContainer)
                            .padding(8.dp),
                        text = title,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        fontSize = MaterialTheme.typography.titleMedium.fontSize,
                        fontStyle = MaterialTheme.typography.titleMedium.fontStyle
                    )
                }
            }
            item {
                SettingsSectionContent(
                    modifier = Modifier.padding(horizontal = 4.dp),
                    settingsItems = item
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}


private val settings = listOf(
    "Общие" to listOf(
        "Настройка 1",
        "Настройка 2",
        "Настройка 3",
        "Настройка 4",
        "Настройка 5",
        "Настройка 6",
        "Настройка 7",
        "Настройка 8",
    ),
    "Специальные" to listOf(
        "Настройка 1",
        "Настройка 2",
        "Настройка 3",
        "Настройка 4",
        "Настройка 5",
        "Настройка 6",
        "Настройка 7",
        "Настройка 8",
    ),
    "Для разработчика" to listOf(
        "Настройка 1",
        "Настройка 2",
        "Настройка 3",
        "Настройка 4",
        "Настройка 5",
        "Настройка 6",
        "Настройка 7",
        "Настройка 8",
    )
)