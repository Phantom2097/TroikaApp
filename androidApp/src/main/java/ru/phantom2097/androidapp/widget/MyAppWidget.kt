package ru.phantom2097.androidapp.widget

import android.content.Context
import androidx.glance.GlanceId
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent

// https://www.youtube.com/watch?v=jI1LKN7jBVk&list=TLPQMjAwMTIwMjaMiCDkLa4lpw&index=3
// TODO: Action для обновления данных
// TODO: Action для добавления поездки
// TODO: Другие размеры для виджета с динамическим изменением
class MyAppWidget : GlanceAppWidget() {
    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            AllSumWidget()
        }
    }

    override suspend fun providePreview(context: Context, widgetCategory: Int) {
        provideContent {
            AllSumWidget()
        }
    }
}