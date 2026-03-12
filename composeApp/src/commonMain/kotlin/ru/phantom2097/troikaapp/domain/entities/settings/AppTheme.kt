package ru.phantom2097.troikaapp.domain.entities.settings

import org.jetbrains.compose.resources.StringResource
import ru.phantom2097.troikaapp.resources.Res
import ru.phantom2097.troikaapp.resources.app_theme_setting_dark
import ru.phantom2097.troikaapp.resources.app_theme_setting_light
import ru.phantom2097.troikaapp.resources.app_theme_setting_system

enum class AppTheme(val strRes: StringResource) {
    SYSTEM(Res.string.app_theme_setting_system),
    LIGHT_MODE(Res.string.app_theme_setting_light),
    DARK_MODE(Res.string.app_theme_setting_dark);

    companion object {
        val defaultValue = SYSTEM

        fun fromString(strName: String): AppTheme = entries.firstOrNull {
            it.name == strName
        } ?: defaultValue

        fun fromInt(id: Int): AppTheme = entries.firstOrNull {
            it.ordinal == id
        } ?: defaultValue
    }
}