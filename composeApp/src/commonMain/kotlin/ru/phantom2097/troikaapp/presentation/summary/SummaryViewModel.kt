package ru.phantom2097.troikaapp.presentation.summary

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.datetime.TimeZone
import ru.phantom2097.troikaapp.domain.use_cases.GetTripHistoryUseCase
import ru.phantom2097.troikaapp.domain.use_cases.SelectTargetPeriodUseCase
import ru.phantom2097.troikaapp.presentation.core.app_events.NavEvent
import ru.phantom2097.troikaapp.presentation.core.app_events.model.AppBottomBarEventBus
import ru.phantom2097.troikaapp.presentation.utils.date.toFormattedDate

class SummaryViewModel(
    private val getTripHistoryUseCase: GetTripHistoryUseCase,
    private val selectTargetPeriodUseCase: SelectTargetPeriodUseCase,

    private val eventBus: AppBottomBarEventBus,
) : ViewModel() {

    val amountSum = getTripHistoryUseCase.getAmountSum()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(STOP_TIMEOUT_LIMIT),
            AMOUNT_SUM_INITIAL_VALUE
        )

    private val _uiState = MutableStateFlow<SummaryUiState>(SummaryUiState.Loading)
    val uiState get() = _uiState.asStateFlow()

    // https://proandroiddev.com/loading-initial-data-in-launchedeffect-vs-viewmodel-f1747c20ce62
    // https://www.youtube.com/watch?v=mNKQ9dc1knI&t=596s
    private val _scrollToTop = MutableSharedFlow<Unit>()
    val scrollToTop = _scrollToTop
        .asSharedFlow()
        .onStart { startCollectEvent() }
        .shareIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(STOP_TIMEOUT_LIMIT)
        )

    private val _dateRange = MutableStateFlow<DateRangePickerState>(DateRangePickerState.Loading)
    val dateRange = _dateRange
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = DateRangePickerState.Loading
        )

    fun startCollectEvent() {
        viewModelScope.launch {
            eventBus.events.collect { event ->
                if (event is NavEvent.SummaryReselected) {
                    _scrollToTop.emit(Unit)
                }
            }
        }
    }

    fun updateSelectedDates(start: Long?, end: Long?) {
        val timeZone = TimeZone.currentSystemDefault()
        val startDate =
            start?.toFormattedDate(timeZone) ?: throw IllegalArgumentException("Неверная начальная дата")
        val endDate =
            end?.toFormattedDate(timeZone) ?: throw IllegalArgumentException("Неверная конечная дата")

        _dateRange.update {
            DateRangePickerState.DateRange("$startDate - $endDate")
        }
    }

    companion object {
        private const val STOP_TIMEOUT_LIMIT = 5000L

        private const val AMOUNT_SUM_INITIAL_VALUE = 0.0
    }
}