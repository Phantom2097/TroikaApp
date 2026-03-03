package ru.phantom2097.troikaapp.presentation.settings

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
                "Switch",
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
                SettingsBlockHeader(
                    text = title
                )
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