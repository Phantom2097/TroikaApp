package ru.phantom2097.troikaapp.presentation.core

import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.vectorResource
import ru.phantom2097.troikaapp.presentation.ui.theme.AppTheme
import ru.phantom2097.troikaapp.resources.Res
import ru.phantom2097.troikaapp.resources.outline_edit_calendar_24

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarItem(
    settingsClickListener: () -> Unit,
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent,
        ),
        title = {
            Text(
                text = "Top Item",
                color = MaterialTheme.colorScheme.primary
            )
        },
        actions = {
            TopAppBarItemActions(settingsClickListener)
        }
    )
}

@Composable
private fun TopAppBarItemActions(settingsClickListener: () -> Unit) {
    IconButton(
        onClick = {
            settingsClickListener()
        }

    ) {
        Icon(
            modifier = Modifier.size(32.dp),
            imageVector = vectorResource(Res.drawable.outline_edit_calendar_24),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
@Preview
private fun TopAppBarItemPreview() {
    AppTheme {
        Scaffold(
            topBar = {
                TopAppBarItem { }
            }
        ) { }
    }
}