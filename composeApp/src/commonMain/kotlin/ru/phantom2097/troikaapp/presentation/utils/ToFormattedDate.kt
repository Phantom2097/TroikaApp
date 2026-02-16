package ru.phantom2097.troikaapp.presentation.utils

import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Instant

internal fun Long.toFormattedDate(): String {
    val date = Instant.fromEpochMilliseconds(this)
        .toLocalDateTime(TimeZone.currentSystemDefault())
        .date

    return with(date) { "$day.$month.$year" }
}