package ru.phantom2097.troikaapp.presentation.summary

sealed class SummaryUiState {

    data object Loading : SummaryUiState()

    data class SummaryData(
        val allSum: String = "0",
        val startDate: String = "",
        val endDate: String = "",
    ) : SummaryUiState()
}