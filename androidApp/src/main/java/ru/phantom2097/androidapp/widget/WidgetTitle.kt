package ru.phantom2097.androidapp.widget

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.Image
import androidx.glance.ImageProvider
import androidx.glance.action.actionStartActivity
import androidx.glance.action.clickable
import androidx.glance.appwidget.ExperimentalGlanceRemoteViewsApi
import androidx.glance.appwidget.cornerRadius
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.ContentScale
import androidx.glance.layout.Row
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.padding
import androidx.glance.layout.size
import androidx.glance.layout.width
import androidx.glance.preview.ExperimentalGlancePreviewApi
import androidx.glance.preview.Preview
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import ru.phantom2097.androidapp.MainActivity
import ru.phantom2097.androidapp.R

@Composable
fun WidgetTitle() {
    Row(
        modifier = GlanceModifier
            .fillMaxWidth()
            .background(GlanceTheme.colors.primary)
            .cornerRadius(8.dp)
            .clickable(actionStartActivity<MainActivity>())
            .padding(horizontal = 12.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = GlanceModifier
                .cornerRadius(8.dp)
                .size(32.dp)
                .background(Color.DarkGray),
            provider = ImageProvider(R.drawable.ic_launcher_foreground),
            contentDescription = null,
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = GlanceModifier.width(12.dp))

        Text(
            text = "Траты по тройке",
            style = TextStyle(
                fontSize = 16.sp,
                color = GlanceTheme.colors.onPrimary
            )
        )
    }
}

@OptIn(ExperimentalGlanceRemoteViewsApi::class, ExperimentalGlancePreviewApi::class)
@Preview(widthDp = 200, heightDp = 100)
@Composable
private fun WidgetTitlePreview() {
    GlanceTheme() {
        WidgetTitle()
    }
}