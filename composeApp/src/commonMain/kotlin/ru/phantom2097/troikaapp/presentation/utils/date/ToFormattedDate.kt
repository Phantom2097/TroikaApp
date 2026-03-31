package ru.phantom2097.troikaapp.presentation.utils.date

import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format
import kotlinx.datetime.format.DateTimeFormat
import kotlinx.datetime.format.FormatStringsInDatetimeFormats
import kotlinx.datetime.format.byUnicodePattern
import kotlinx.datetime.toLocalDateTime
import ru.phantom2097.troikaapp.domain.entities.date_period.DateSeparatorType
import ru.phantom2097.troikaapp.domain.entities.date_period.FormattedDateType
import ru.phantom2097.troikaapp.domain.entities.date_period.FormattedDateType.Companion.applySeparator
import kotlin.time.Instant

internal fun Long.toFormattedDate(
    timeZone: TimeZone,
    formattedDateType: FormattedDateType = FormattedDateType.DMY, // use DateFormatSettings
    separatorType: DateSeparatorType = DateSeparatorType.DOT
): String {

    val date = Instant.fromEpochMilliseconds(this)
        .toLocalDateTime(timeZone)
        .date

    val typeWithSeparator = formattedDateType.applySeparator(type = separatorType)

    val format = dateFormatterFromPattern(typeWithSeparator)

    return toFormatDate(date, format)
}

@OptIn(FormatStringsInDatetimeFormats::class)
private fun dateFormatterFromPattern(formatPattern: String) = LocalDate.Format {
    byUnicodePattern(formatPattern)
}

private fun toFormatDate(date: LocalDate, dtFormat: DateTimeFormat<LocalDate>): String =
    date.format(dtFormat)