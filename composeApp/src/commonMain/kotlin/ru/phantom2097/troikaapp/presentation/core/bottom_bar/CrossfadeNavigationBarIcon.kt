package ru.phantom2097.troikaapp.presentation.core.bottom_bar

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.EaseInOutCirc
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.vectorResource

@Composable
fun CrossfadeNavigationBarIcon(
    isSelectedKey: Boolean,
    iconBold: DrawableResource,
    iconOutline: DrawableResource,
    description: String?,
) {
    val iconBold = vectorResource(iconBold)
    val iconOutline = vectorResource(iconOutline)
    Crossfade(
        targetState = isSelectedKey,
        label = "IconCrossfade",
        animationSpec = tween(600, easing = EaseInOutCirc)
    ) { isSelected ->

        val icon = if (isSelected) {
            iconBold
        } else {
            iconOutline
        }

        Icon(
            modifier = Modifier.size(36.dp),
            imageVector = icon,
            contentDescription = description,
            tint = if (isSelected) {
                MaterialTheme.colorScheme.onPrimaryContainer
            } else {
                MaterialTheme.colorScheme.onSecondaryContainer
            }
        )
    }
}

@Preview
@Composable
private fun CrossfadeNavigationBarIconPreview(
) {
    val item = AppTabs.entries[0]
    CrossfadeNavigationBarIcon(
        isSelectedKey = true,
        iconBold = item.iconBold,
        iconOutline = item.iconOutline,
        description = item.description,
    )
}