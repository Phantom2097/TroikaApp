package ru.phantom2097.troikaapp.presentation.settings

import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.phantom2097.troikaapp.presentation.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun SettingsIconWithSwitch(
    text: String,
    initialState: Boolean,
    onCheckedChange: (Boolean) -> Unit,
) {

    var isChecked by remember {
        mutableStateOf(initialState)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 8.dp),
            text = text,
            fontSize = 24.sp,
            maxLines = 1
        )

        Row(
            modifier = Modifier.height(IntrinsicSize.Min),
            verticalAlignment = Alignment.CenterVertically
        ) {
            VerticalDivider(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(4.dp),
                thickness = 1.dp
            )

            Spacer(modifier = Modifier.width(8.dp))

            Switch(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                checked = isChecked,
                onCheckedChange = {
                    isChecked = !isChecked
                    onCheckedChange(it)
                },
            )
        }
    }
}

@Preview
@Composable
fun SettingsIconWithSwitchPreview() {
    AppTheme {
        SettingsIconWithSwitch(
            text = "Включить настройку",
            initialState = true,
            onCheckedChange = { }
        )
    }
}