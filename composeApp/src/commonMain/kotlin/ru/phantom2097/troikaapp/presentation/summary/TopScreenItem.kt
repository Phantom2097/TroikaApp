package ru.phantom2097.troikaapp.presentation.summary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.phantom2097.troikaapp.presentation.core.ui.AppModifiers.collapseAndClip
import ru.phantom2097.troikaapp.presentation.summary.select_date.DateChooseItemWithDates
import ru.phantom2097.troikaapp.presentation.ui.theme.AppTheme

@Composable
fun TopScreenItem(
    modifier: Modifier = Modifier,
    scrollProvider: () -> Int,
    dateRange: DateRangePickerState,
    allSum: String,
    datePickerListener: () -> Unit,
    loadDataListener: () -> Unit,
) {

    var topBlock by remember { mutableIntStateOf(0) }
    var bottomBlock by remember { mutableIntStateOf(0) }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
        )
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(4.dp))

            Column(
                modifier = Modifier
                    .collapseAndClip {
                        scrollProvider().coerceIn(0, topBlock)
                    }
                    .onSizeChanged { size ->
                        topBlock = size.height
                    },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .background(MaterialTheme.colorScheme.primaryContainer)
                        .padding(
                            vertical = 4.dp,
                            horizontal = 8.dp
                        ),
                    text = "Всего потрачено",
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )

                Spacer(modifier = Modifier.height(4.dp))
            }

            CurrentWastedSum(allSum)

            DateChooseItemWithDates(
                collapseProvider = {
                    maxOf(0, scrollProvider() - topBlock).coerceIn(0, bottomBlock)
                },
                bottomBlockChange = { bottomBlock = it },
                datePickerListener,
                dateRange,
            )

            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

@Preview
@Composable
private fun TopScreenItemPreview() {
    AppTheme {
        TopScreenItem(
            scrollProvider = { 0 },
            allSum = "60000",
            datePickerListener = { },
            dateRange = DateRangePickerState.DateRange("19.06.25 - 27.12.2037"),
        ) { }
    }
}