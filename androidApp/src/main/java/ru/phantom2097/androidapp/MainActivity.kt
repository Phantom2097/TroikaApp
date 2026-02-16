package ru.phantom2097.androidapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.glance.appwidget.GlanceAppWidgetManager
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.phantom2097.androidapp.widget.FirstAppWidget
import ru.phantom2097.troikaapp.presentation.App

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        //TODO: выделить создание виджетов в отдельный метод, как в видео https://youtu.be/_Akf_u08p7U?si=WwCm43IPr4cKXutC&t=445
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.VANILLA_ICE_CREAM) {
            lifecycleScope.launch(Dispatchers.Default) {
                GlanceAppWidgetManager(this@MainActivity)
                    .setWidgetPreviews(FirstAppWidget::class)
            }
        }

        setContent {
            App()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}