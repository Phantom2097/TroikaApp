package ru.phantom2097.troikaapp.presentation.summary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.compose.viewmodel.koinViewModel
import ru.phantom2097.troikaapp.navigation.AppRoutes
import ru.phantom2097.troikaapp.navigation.Navigator
import ru.phantom2097.troikaapp.navigation.rememberNavigationState
import ru.phantom2097.troikaapp.presentation.ProgressItemWithText
import ru.phantom2097.troikaapp.presentation.history.charts.DemoLineChart
import ru.phantom2097.troikaapp.presentation.ui.theme.AppTheme

@Composable
fun SummaryScreen(
    innerPadding: PaddingValues,
    navToHistoryScreen: () -> Unit,
    datePicker: () -> Unit,
    navigator: Navigator,
    summaryViewModel: SummaryViewModel = koinViewModel<SummaryViewModel>(),
) {
    val hapticFeedback = LocalHapticFeedback.current
    val scrollState = rememberLazyListState()
    val allSum = summaryViewModel.amountSum.collectAsStateWithLifecycle()
    val dateRange = summaryViewModel.dateRange.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        summaryViewModel.scrollToTop.collect {
            scrollState.scrollToItem(0)
            hapticFeedback.performHapticFeedback(HapticFeedbackType.Confirm)
        }
    }

    SummaryLayout(
        innerPadding = innerPadding,
        scrollState = scrollState,
        allSum = allSum.value.toString(),
        dateRange = dateRange.value,
        datePicker = { datePicker() },
        navToHistoryScreen = { navToHistoryScreen() },
        navigator = navigator
    )
}

//private class CollapsingAppBarNestedScrollConnection(
//    val appBarMaxHeight: Int
//) : NestedScrollConnection {
//
//    var appBarOffset: Int by mutableIntStateOf(0)
//        private set
//
//    override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
//        val delta = available.y.toInt()
//        val newOffset = appBarOffset + delta
//        val previousOffset = appBarOffset
//        appBarOffset = newOffset.coerceIn(-appBarMaxHeight, 0)
//        val consumed = appBarOffset - previousOffset
//        return Offset(0f, consumed.toFloat())
//    }
//}

@Composable
fun SummaryLayout(
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues,
    scrollState: LazyListState,
    dateRange: DateRangePickerState,
    allSum: String,
    datePicker: () -> Unit,
    navToHistoryScreen: () -> Unit,
    navigator: Navigator,
) {
    val density = LocalDensity.current

    var headerHeightPx by remember { mutableIntStateOf(0) }
    val headerHeightDp =
        with(density) { headerHeightPx.toDp() }


    val scrollOffsetPx by remember {
        derivedStateOf {
            if (scrollState.firstVisibleItemIndex == 0) {
                scrollState.firstVisibleItemScrollOffset
            } else {
                Int.MAX_VALUE
            }
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 4.dp),
            state = scrollState,
            contentPadding = PaddingValues(
                top = innerPadding.calculateTopPadding() + headerHeightDp,
                bottom = innerPadding.calculateBottomPadding()
            )
        ) {
            item {
                SummaryListItem(
                    modifier = Modifier.padding(4.dp),
                    title = "Статистика",
                    openScreenClickListener = { navigator.navigate(AppRoutes.HistoryRoute) }
                ) {
                    DemoLineChart()
                }
            }
            item {
                SummaryListItem(
                    modifier = Modifier.padding(4.dp),
                    title = "История",
                    openScreenClickListener = {}
                ) {
                    Text(
                        text = "Здесь будут последние поездки",
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
            item {
                SummaryListItem(
                    modifier = Modifier.padding(4.dp),
                    title = "Подписки",
                    openScreenClickListener = {}
                ) {
                    Text(
                        text = "Здесь будет сравнение подписки с оплатой",
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
            items(50) {
                HorizontalDivider(modifier = Modifier.padding(4.dp))
                Text(
                    modifier = Modifier
                        .padding(4.dp),
                    text = "Название подписки $it"
                )
                ProgressItemWithText(
                    50 - it.toDouble(),
                    it.toDouble()
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = innerPadding.calculateTopPadding())
                .onSizeChanged { size ->
                    if (size.height > headerHeightPx) headerHeightPx = size.height
                }
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.background,
                            MaterialTheme.colorScheme.background,
                            Color.Transparent
                        ),
                    )
                )
        ) {
            TopScreenItem(
                modifier = Modifier,
                scrollProvider = { scrollOffsetPx },
                dateRange = dateRange,
                allSum = allSum,
                datePickerListener = { datePicker() }
            ) { navToHistoryScreen() }
        }
    }
}

@Preview
@PreviewDynamicColors
@Composable
private fun SummaryScreenPreview() {
    AppTheme {
        SummaryLayout(
            innerPadding = PaddingValues(),
            allSum = "34234",
            dateRange = DateRangePickerState.DateRange("19.06.25 - 27.12.2037"),
            scrollState = rememberLazyListState(),
            datePicker = {},
            navToHistoryScreen = {},
            navigator = Navigator(rememberNavigationState(AppRoutes.SummaryRoute, emptySet()))
        )
    }
}