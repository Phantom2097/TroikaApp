package ru.phantom2097.troikaapp.view_model

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import ru.phantom2097.troikaapp.domain.repository.MetroRepository
import ru.phantom2097.troikaapp.domain.use_cases.GetTripHistoryUseCase
import ru.phantom2097.troikaapp.domain.use_cases.SelectTargetPeriodUseCase
import ru.phantom2097.troikaapp.presentation.core.app_events.impl.AppBottomBarEventBusImpl
import ru.phantom2097.troikaapp.presentation.summary.SummaryUiState
import ru.phantom2097.troikaapp.presentation.summary.SummaryViewModel
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@OptIn(ExperimentalCoroutinesApi::class)
class SummaryViewModelTest {
    private lateinit var repository: MetroRepository
    private lateinit var viewModel: SummaryViewModel

    private val testDispatcher = StandardTestDispatcher()

    @BeforeTest
    fun setup() {
        Dispatchers.setMain(testDispatcher)

        repository = TestRepository()

        viewModel = SummaryViewModel(
            getTripHistoryUseCase = GetTripHistoryUseCase(repository),
            selectTargetPeriodUseCase = SelectTargetPeriodUseCase(),
            eventBus = AppBottomBarEventBusImpl()
        )
    }

    @AfterTest
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `initial uiState is Loading`() = runTest {
        assertEquals(SummaryUiState.Loading, viewModel.uiState.value)
    }

    @Test
    fun `updateSelectedDates changes uiState to SummaryData`() = runTest {
        val startTimestamp = 1704067200000L
        val endTimestamp = 1704153600000L

        viewModel.updateSelectedDates(startTimestamp, endTimestamp)

        val state = viewModel.uiState.value
        assertTrue(state is SummaryUiState.SummaryData, "State should be SummaryData $state")
    }
}