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
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import ru.phantom2097.troikaapp.domain.use_cases.GetTripHistoryUseCase
import ru.phantom2097.troikaapp.domain.use_cases.SelectTargetPeriodUseCase
import ru.phantom2097.troikaapp.presentation.core.app_events.NavEvent
import ru.phantom2097.troikaapp.presentation.core.app_events.model.AppBottomBarEventBus
import ru.phantom2097.troikaapp.presentation.utils.toFormattedDate
import kotlin.time.Instant

class SummaryViewModel(
    private val getTripHistoryUseCase: GetTripHistoryUseCase,
    private val selectTargetPeriodUseCase: SelectTargetPeriodUseCase,

    private val eventBus: AppBottomBarEventBus,
) : ViewModel() {

//    val amountSum: StateFlow<Double>
//        field = MutableStateFlow<Double>(0.0)

    private val _amountSum = MutableStateFlow<Double>(0.0)
    val amountSum get() = _amountSum.asStateFlow()

//    val uiState: StateFlow<SummaryUiState>
//        field = MutableStateFlow<SummaryUiState>(SummaryUiState.Loading)

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
            started = SharingStarted.WhileSubscribed()
        )

//    val selectedDates: StateFlow<Pair<Long, Long>>
//        field = MutableStateFlow<Pair<Long, Long>>(0L to 0L)

    private val _selectedDates = MutableStateFlow<Pair<Long, Long>>(0L to 0L)
    val selectedDates = _selectedDates.asStateFlow()

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
        val startDate =
            start?.toFormattedDate() ?: throw IllegalArgumentException("Неверная начальная дата")
        val endDate =
            end?.toFormattedDate() ?: throw IllegalArgumentException("Неверная конечная дата")

        _uiState.update {
            SummaryUiState.SummaryData(
                startDate = startDate,
                endDate = endDate,
            )
        }
    }

    // TODO: remove that shit
    fun getStartDate(): String {
        val instant = Instant.fromEpochMilliseconds(selectedDates.value.first)
        val dateTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())
        val startDate = dateTime.date.toString()

        return startDate
    }

    fun getEndDate(): String {
        val instant = Instant.fromEpochMilliseconds(selectedDates.value.second)
        val dateTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())
        val startDate = dateTime.date.toString()

        return startDate
    }


//    private val _amountSum = MutableStateFlow<Double>(0.0)
//    val amountSum get() = _amountSum.asStateFlow()
}