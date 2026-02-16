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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.compose.viewmodel.koinViewModel
import ru.phantom2097.troikaapp.presentation.ProgressItemWithText
import ru.phantom2097.troikaapp.presentation.ui.theme.AppTheme

@Composable
fun SummaryScreen(
    innerPadding: PaddingValues,
    navToHistoryScreen: () -> Unit,
    datePicker: () -> Unit,
    summaryViewModel: SummaryViewModel = koinViewModel<SummaryViewModel>(),
) {
    val scrollState = rememberLazyListState()
    val allSum = summaryViewModel.amountSum.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        summaryViewModel.scrollToTop.collect {
            scrollState.animateScrollToItem(0)
        }
    }

    SummaryLayout(
        innerPadding = innerPadding,
        scrollState = scrollState,
        allSum = allSum.value.toString(),
        startDate = summaryViewModel.getStartDate(),
        endDate = summaryViewModel.getEndDate(),
        datePicker = { datePicker() },
    ) { navToHistoryScreen() }
}

@Composable
fun SummaryLayout(
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues,
    scrollState: LazyListState,
    allSum: String,
    startDate: String,
    endDate: String,
    datePicker: () -> Unit,
    navToHistoryScreen: () -> Unit,
) {
    val density = LocalDensity.current

    var headerHeightDp by remember { mutableStateOf(0.dp) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        LazyColumn(
            modifier = Modifier,
            state = scrollState,
            contentPadding = PaddingValues(
                top = innerPadding.calculateTopPadding() + headerHeightDp,
                bottom = innerPadding.calculateBottomPadding()
            )
        ) {
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
                    headerHeightDp = with(density) { size.height.toDp() }
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
                startDate = startDate,
                endDate = endDate,
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
            startDate = "16.23.3444",
            endDate = "27.43.2333",
            scrollState = rememberLazyListState(),
            datePicker = {}
        ) { }
    }
}