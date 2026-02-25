package ru.phantom2097.troikaapp.domain.entites.settings

import ru.phantom2097.troikaapp.domain.models.DateFormatStyle

data class UserSettings(
    val theme: Int, // do theme enum
    val dateFormatStyle: DateFormatStyle,
    val lang: Int,

)
