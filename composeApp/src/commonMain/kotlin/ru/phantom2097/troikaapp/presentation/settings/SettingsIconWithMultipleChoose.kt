package ru.phantom2097.troikaapp.presentation.settings

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.phantom2097.troikaapp.presentation.core.ui.CrossfadeIcon
import ru.phantom2097.troikaapp.presentation.core.ui.CrossfadeIconDefaults
import ru.phantom2097.troikaapp.resources.Res
import ru.phantom2097.troikaapp.resources.alt_arrow_down_bold
import ru.phantom2097.troikaapp.resources.alt_arrow_down_outline

@Composable
fun SettingsIconWithMultipleChoose(
    label: String,
    selectedOption: String,
    options: List<String>,
    onOptionSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
    subText: String? = null,
) {
    var isExpanded by remember {
        mutableStateOf(false)
    }
    val angle by animateFloatAsState(
        targetValue = if (isExpanded) 180f else 0f,
        animationSpec = tween(durationMillis = 600), // Длительность анимации
        label = "rotation"
    )

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 8.dp),
        ) {
            Text(

                text = label,
                fontSize = 24.sp,
                maxLines = 1
            )

            subText?.let { text ->
                Text(
                    text = text,
                    fontStyle = FontStyle.Normal,
                    maxLines = 3,
                    color = MaterialTheme.colorScheme.surfaceTint
                )
            }
        }

//        VerticalDivider(
//            modifier = Modifier
//                .wrapContentHeight()
//                .padding(4.dp)
//        )
//
//        Spacer(modifier = Modifier.width(8.dp))


        AnimatedContent(

            targetState = selectedOption,
            transitionSpec = {
                fadeIn() togetherWith fadeOut()
            }
        ) { option ->
            Row(
                modifier = Modifier
                    .width(IntrinsicSize.Max)
                    .padding(4.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .clickable {
                        isExpanded = !isExpanded
                    }
                    .padding(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(option)

                CrossfadeIcon(
                    modifier = Modifier
                        .graphicsLayer {
                            rotationX = angle
                        },
                    isSelectedIcon = isExpanded,
                    iconSelected = Res.drawable.alt_arrow_down_bold,
                    iconUnselected = Res.drawable.alt_arrow_down_outline,
                    description = null,
                    colors = CrossfadeIconDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.primary,
                        unSelectedIconColor = MaterialTheme.colorScheme.primary
                    ),
                    size = 36.dp
                )
            }

            DropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false },
            ) {
                options.forEachIndexed { index, string ->
                    DropdownMenuItem(
                        text = { Text(text = string) },
                        onClick = {
                            onOptionSelected(index)
                            isExpanded = !isExpanded
                        }
                    )
                }
            }
        }
    }
}

//@Preview
//@Composable
//fun SettingsIconWithMultipleChoosePreview() {
//    AppTheme {
//        SettingsIconWithMultipleChoose(
//            text = "Включить настройку",
//            initialValue = true,
//            onCheckedChange = { }
//        )
//    }
//}
