package ru.phantom2097.troikaapp.presentation.utils

import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock
import kotlin.time.Instant

// TODO: Вынести определение часового пояса, локального времени и используемый формат в переменные
// TODO: Создать enum, с возможными форматами
// TODO: Хранить в дата стор и передавать через репозиторий настроек
internal fun Long.toFormattedDate(): String {

    val timeZone = TimeZone.currentSystemDefault()

    val date = Instant.fromEpochMilliseconds(this)
        .toLocalDateTime(timeZone)
        .date
    val currentDate = Clock.System.now().toLocalDateTime(timeZone).date

    if (date > currentDate) {
        return toFormatDate(currentDate)
    }

    return toFormatDate(date)
}

private fun toFormatDate(date: LocalDate): String = with(date) { "$day.$month.$year" }