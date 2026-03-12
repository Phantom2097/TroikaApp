package ru.phantom2097.troikaapp.presentation.settings

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.LayoutDirection
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import ru.phantom2097.troikaapp.domain.entities.settings.AppSettings
import ru.phantom2097.troikaapp.domain.entities.settings.AppTheme
import ru.phantom2097.troikaapp.resources.Res
import ru.phantom2097.troikaapp.resources.app_theme_setting
import ru.phantom2097.troikaapp.resources.app_theme_setting_subText

@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues = PaddingValues(),
) {
    val settingsViewModel = koinViewModel<SettingsViewModel>()
    val settingsState = settingsViewModel.appSettings.collectAsStateWithLifecycle()

    val paddingValues = PaddingValues(
        end = innerPadding.calculateEndPadding(LayoutDirection.Ltr),
        start = innerPadding.calculateStartPadding(LayoutDirection.Ltr),
        bottom = innerPadding.calculateBottomPadding()
    )
    val topPadding = innerPadding.calculateTopPadding()

    SettingsLayout(
        modifier = modifier
            .padding(top = topPadding),
        paddingValues = paddingValues,
        currentAppSettings = settingsState.value,
        settingsViewModel = settingsViewModel
    )
}

@Composable
private fun SettingsLayout(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
    currentAppSettings: AppSettings,
    settingsViewModel: SettingsViewModel, // use Events
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = paddingValues
    ) {
        item {
            SettingsIconWithMultipleChoose(
                label = stringResource(Res.string.app_theme_setting),
                selectedOption = stringResource(currentAppSettings.theme.strRes),
                options = AppTheme.entries.map { stringResource(it.strRes) },
                onOptionSelected = { newThemeId ->
                    settingsViewModel.changeTheme(AppTheme.fromInt(newThemeId)) // I think is bad shit, but now I don't know how to implement this better
                },
                subText = stringResource(Res.string.app_theme_setting_subText)
            )
        }
        item {

        }
        item {

        }
    }
}