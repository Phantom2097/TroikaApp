package ru.phantom2097.androidapp.widget

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.glance.ColorFilter
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.Image
import androidx.glance.ImageProvider
import androidx.glance.action.Action
import androidx.glance.action.actionStartActivity
import androidx.glance.action.clickable
import androidx.glance.appwidget.ExperimentalGlanceRemoteViewsApi
import androidx.glance.appwidget.cornerRadius
import androidx.glance.layout.Alignment
import androidx.glance.layout.Box
import androidx.glance.layout.padding
import androidx.glance.preview.ExperimentalGlancePreviewApi
import androidx.glance.preview.Preview
import androidx.glance.unit.ColorProvider
import ru.phantom2097.androidapp.MainActivity
import ru.phantom2097.androidapp.R


@Composable
fun WidgetIconButton(
    modifier: GlanceModifier = GlanceModifier,
    icon: Int,
    iconColor: ColorProvider = GlanceTheme.colors.onPrimary,
    description: String = "Action",
    cornerRadius: Dp = 4.dp,
    innerPadding: Dp = 0.dp,
    onClick: Action,
) {
    Box(
        modifier = modifier
            .padding(innerPadding)
            .cornerRadius(cornerRadius)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Image(
            provider = ImageProvider(icon),
            contentDescription = description,
            colorFilter = ColorFilter.tint(iconColor)
        )
    }
}

@OptIn(ExperimentalGlanceRemoteViewsApi::class, ExperimentalGlancePreviewApi::class)
@Preview(widthDp = 200, heightDp = 100)
@Composable
private fun WidgetIconButton() {
    GlanceTheme {
        WidgetIconButton(
            modifier = GlanceModifier,
            icon = R.drawable.refresh,
            onClick = actionStartActivity<MainActivity>()
        )
    }
}