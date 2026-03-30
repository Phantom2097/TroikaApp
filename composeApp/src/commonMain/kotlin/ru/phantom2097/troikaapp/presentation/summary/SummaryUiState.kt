package ru.phantom2097.troikaapp.presentation.summary

import androidx.compose.runtime.Stable

sealed class SummaryUiState {

    data object Loading : SummaryUiState()

    data class SummaryData(
        val allSum: String = "0",
        val startDate: String = "",
        val endDate: String = "",
    ) : SummaryUiState()
}

@Stable
sealed interface DateRangePickerState {
    data object Loading : DateRangePickerState
    data class DateRange(val dateRange: String) : DateRangePickerState
}