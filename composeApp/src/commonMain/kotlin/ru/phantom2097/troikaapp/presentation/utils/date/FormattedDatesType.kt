package ru.phantom2097.troikaapp.presentation.utils.date

import ru.phantom2097.troikaapp.presentation.utils.date.DatePart.DAY
import ru.phantom2097.troikaapp.presentation.utils.date.DatePart.MONTH
import ru.phantom2097.troikaapp.presentation.utils.date.DatePart.YEAR

internal enum class FormattedDatesType(private val date: List<DatePart>) {
    DMY(listOf(DAY, MONTH, YEAR)),
    YMD(listOf(YEAR, MONTH, DAY)),
    MDY(listOf(MONTH, DAY, YEAR)),
    ;

    companion object {
        fun FormattedDatesType.applySeparator(separator: String = ".") =
            this.date.joinToString(separator) {
                when (it) {
                    DAY -> "dd"
                    MONTH -> "MM"
                    YEAR -> "yyyy"
                }
            }
    }
}

private enum class DatePart {
    DAY, MONTH, YEAR
}