package ru.phantom2097.androidapp.widget

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.action.actionStartActivity
import androidx.glance.appwidget.components.Scaffold
import androidx.glance.appwidget.cornerRadius
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Box
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxHeight
import androidx.glance.layout.fillMaxSize
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
fun AllSumWidget() {
    val allSum = 3000
    val lastUpdate = "19.34.2026"
    val dateStart = "07.23.2025"

    GlanceTheme {
        Scaffold(
            backgroundColor = GlanceTheme.colors.widgetBackground,
            horizontalPadding = 0.dp,
            titleBar = {
                WidgetTitle()
            }
        ) {
            Column(
                modifier = GlanceModifier
                    .fillMaxSize(),
            ) {
                Row(
                    modifier = GlanceModifier
                        .fillMaxWidth()
                        .defaultWeight()
                        .padding(horizontal = 6.dp),
                ) {
                    Box(
                        modifier = GlanceModifier
                            .fillMaxHeight()
                            .defaultWeight(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            modifier = GlanceModifier,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                modifier = GlanceModifier,
                                style = TextStyle(
                                    fontSize = 10.sp,
                                    color = GlanceTheme.colors.onBackground
                                ),
                                maxLines = 1,
                                text = "Потрачено с $dateStart"
                            )
                            Text(
                                text = "$allSum р",
                                style = TextStyle(
                                    fontSize = 24.sp,
                                    color = GlanceTheme.colors.onBackground
                                )
                            )
                        }
                    }

                    Box(
                        modifier = GlanceModifier
                            .fillMaxHeight()
                            .defaultWeight(),
                        contentAlignment = Alignment.Center
                    ) {

                        WidgetIconButton(
                            modifier = GlanceModifier
                                .size(48.dp)
                                .background(GlanceTheme.colors.secondaryContainer),
                            icon = R.drawable.rounded_add_24,
                            iconColor = GlanceTheme.colors.onSecondaryContainer,
                            onClick = actionStartActivity<MainActivity>()
                        )
                    }
                }

                Row(
                    modifier = GlanceModifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "Обновлено: $lastUpdate",
                        style = TextStyle(
                            fontSize = 10.sp,
                        )
                    )

                    Spacer(modifier = GlanceModifier.width(4.dp))

                    WidgetIconButton(
                        modifier = GlanceModifier.size(16.dp),
                        icon = R.drawable.refresh,
                        iconColor = GlanceTheme.colors.onBackground,
                        onClick = actionStartActivity<MainActivity>()
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalGlancePreviewApi::class)
@Preview(widthDp = 220, heightDp = 100)
@Composable
private fun AllSumWidgetPreview() {
    GlanceTheme {
        Box(
            modifier = GlanceModifier
                .fillMaxSize()
                .cornerRadius(16.dp),
            contentAlignment = Alignment.Center
        ) {
            AllSumWidget()
        }
    }
}