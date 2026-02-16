package ru.phantom2097.troikaapp.presentation.settings

import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import org.jetbrains.compose.resources.vectorResource
import ru.phantom2097.troikaapp.presentation.ui.theme.AppTheme
import ru.phantom2097.troikaapp.resources.Res
import ru.phantom2097.troikaapp.resources.home_smile_bold

@Composable
fun SettingsIconWithMultipleChoose(
    text: String,
    initialValue: Boolean,
    onCheckedChange: (Boolean) -> Unit,
) {
    var isExpanded by remember {
        mutableStateOf(false)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 8.dp),
            text = "Включить настройку",
            fontSize = 24.sp,
            maxLines = 1
        )

        VerticalDivider(
            modifier = Modifier
                .wrapContentHeight()
                .padding(4.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("sldjkf")
            IconButton(
                onClick = { isExpanded = !isExpanded }
            ) {
                Icon(
                    imageVector = vectorResource(Res.drawable.home_smile_bold),
                    contentDescription = null
                )
            }
            DropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false },
            ) {
                repeat(4) {
                    DropdownMenuItem(
                        text = { Text("text $it") },
                        onClick = { }
                    )
                }

            }
        }

    }
}

@Preview
@Composable
fun SettingsIconWithMultipleChoosePreview() {
    AppTheme {
        SettingsIconWithMultipleChoose(
            text = "Включить настройку",
            initialValue = true,
            onCheckedChange = { }
        )
    }
}
