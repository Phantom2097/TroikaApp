package ru.phantom2097.troikaapp.domain.use_cases

import kotlinx.datetime.LocalDate

class SelectTargetPeriodUseCase {
    operator fun invoke(dateRange: String): String {
        return dateRange
    }

    fun setDate(dates: Pair<LocalDate, LocalDate>) {

    }
}