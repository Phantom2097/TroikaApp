package ru.phantom2097.troikaapp.presentation.core.ui

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.EaseInOutCirc
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.vectorResource
import ru.phantom2097.troikaapp.presentation.core.bottom_bar.AppTabs

@Composable
fun CrossfadeIcon(
    modifier: Modifier = Modifier,
    isSelectedIcon: Boolean,
    iconBold: DrawableResource,
    iconOutline: DrawableResource,
    description: String?,
    colors: CrossfadeIconColors = CrossfadeIconDefaults.colors(),
    size: Dp = CrossfadeIconDefaults.iconSize
) {

    val iconBold = vectorResource(iconBold)
    val iconOutline = vectorResource(iconOutline)

    Crossfade(
        targetState = isSelectedIcon,
        label = "IconCrossfade",
        animationSpec = tween(600, easing = EaseInOutCirc)
    ) { isSelected ->

        val icon = if (isSelected) {
            iconBold
        } else {
            iconOutline
        }

        val tint by colors.iconColor(isSelected)

        Icon(
            modifier = modifier.size(size),
            imageVector = icon,
            contentDescription = description,
            tint = tint
        )
    }
}

object CrossfadeIconDefaults {
    val iconSize = 24.dp

    @Composable
    fun colors(
        selectedIconColor: Color = Color.Unspecified,
        unSelectedIconColor: Color = Color.Unspecified,
    ): CrossfadeIconColors = CrossfadeIconColors(
        selectedIconColor = selectedIconColor,
        unSelectedIconColor = unSelectedIconColor
    )
}

@Immutable
class CrossfadeIconColors(
    val selectedIconColor: Color,
    val unSelectedIconColor: Color,
) {
    @Composable
    fun iconColor(selected: Boolean): State<Color> {
        return rememberUpdatedState(if (selected) selectedIconColor else unSelectedIconColor)
    }
}

@Preview
@Composable
private fun CrossfadeIconPreview(
) {
    val item = AppTabs.entries[0]
    CrossfadeIcon(
        isSelectedIcon = true,
        iconBold = item.iconBold,
        iconOutline = item.iconOutline,
        description = item.description,
    )
}