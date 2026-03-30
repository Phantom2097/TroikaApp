package ru.phantom2097.troikaapp.utils.date_picker

import kotlinx.datetime.TimeZone
import ru.phantom2097.troikaapp.presentation.utils.date.FormattedDatesType
import ru.phantom2097.troikaapp.presentation.utils.date.toFormattedDate
import kotlin.test.Test
import kotlin.test.assertEquals

class DateRangePickerTest {
    private val timeZone = TimeZone.UTC
    @Test
    fun `get date from epoch`() {
        val date = DATE_FOR_TESTS.toFormattedDate(timeZone)

        assertEquals("30.03.2026", date)
    }

    @Test
    fun `actual date have format dmy`() {
        val date = DATE_FOR_TESTS.toFormattedDate(timeZone, FormattedDatesType.DMY)

        assertEquals("30.03.2026", date)
    }

    @Test
    fun `actual date have format ymd`() {
        val date = DATE_FOR_TESTS.toFormattedDate(timeZone, FormattedDatesType.YMD)

        assertEquals("2026.03.30", date)
    }

    @Test
    fun `actual date have format mdy`() {
        val date = DATE_FOR_TESTS.toFormattedDate(timeZone, FormattedDatesType.MDY)

        assertEquals("03.30.2026", date)
    }

    private companion object {
        private const val DATE_FOR_TESTS = 1_774_828_800_000L
    }
}

// TODO: add separator enum and tests for them