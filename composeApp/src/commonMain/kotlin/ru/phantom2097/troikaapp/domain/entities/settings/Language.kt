package ru.phantom2097.troikaapp.domain.entities.settings

import org.jetbrains.compose.resources.StringResource
import ru.phantom2097.troikaapp.resources.Res
import ru.phantom2097.troikaapp.resources.app_language_setting_en
import ru.phantom2097.troikaapp.resources.app_language_setting_ru
import ru.phantom2097.troikaapp.resources.app_language_setting_system

enum class Language(val strRes: StringResource) {
    SYSTEM(Res.string.app_language_setting_system),
    ENGLISH(Res.string.app_language_setting_en),
    RUSSIAN(Res.string.app_language_setting_ru);

    companion object {
        val defaultValue = SYSTEM

        fun fromString(strName: String): Language = entries.firstOrNull {
            it.name == strName
        } ?: defaultValue

        fun fromInt(id: Int): Language = entries.getOrNull(id) ?: defaultValue
    }
}