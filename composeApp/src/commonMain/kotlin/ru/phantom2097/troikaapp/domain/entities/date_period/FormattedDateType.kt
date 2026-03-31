package ru.phantom2097.troikaapp.domain.entities.date_period

import ru.phantom2097.troikaapp.domain.entities.date_period.DatePart.DAY
import ru.phantom2097.troikaapp.domain.entities.date_period.DatePart.MONTH
import ru.phantom2097.troikaapp.domain.entities.date_period.DatePart.YEAR

enum class FormattedDateType(private val date: List<DatePart>) {
    DMY(listOf(DAY, MONTH, YEAR)),
    YMD(listOf(YEAR, MONTH, DAY)),
    MDY(listOf(MONTH, DAY, YEAR)),
    ;

    companion object {
        fun FormattedDateType.applySeparator(type: DateSeparatorType = DateSeparatorType.DOT) =
            this.date.joinToString(type.separator) {
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