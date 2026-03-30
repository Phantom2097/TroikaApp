package ru.phantom2097.troikaapp.presentation.summary.select_date

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularWavyProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.vectorResource
import ru.phantom2097.troikaapp.presentation.core.ui.AppModifiers.collapseAndClip
import ru.phantom2097.troikaapp.presentation.summary.DateRangePickerState
import ru.phantom2097.troikaapp.resources.Res
import ru.phantom2097.troikaapp.resources.outline_edit_calendar_24

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun DateChooseItemWithDates(
    collapseProvider: () -> Int,
    bottomBlockChange: (Int) -> Unit,
    datePickerListener: () -> Unit,
    dateRange: DateRangePickerState,
) {
    Column(
        modifier = Modifier
            .collapseAndClip {
                collapseProvider()
            }
            .onSizeChanged { size ->
                bottomBlockChange(size.height)
            }
    ) {
        Spacer(modifier = Modifier.height(4.dp))

        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.primaryContainer)
                .clickable {
                    datePickerListener()
                }
                .padding(vertical = 4.dp, horizontal = 8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (dateRange) {
                is DateRangePickerState.DateRange -> {
                    Icon(
                        imageVector = vectorResource(Res.drawable.outline_edit_calendar_24),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = dateRange.dateRange,
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }

                DateRangePickerState.Loading -> {
                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        CircularWavyProgressIndicator()
                        Icon(
                            imageVector = vectorResource(Res.drawable.outline_edit_calendar_24),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun DateChooseItemWithDatesPreview() {
    DateChooseItemWithDates(
        collapseProvider = { 0 },
        bottomBlockChange = {  },
        datePickerListener = {  },
        dateRange = DateRangePickerState.DateRange("19.06.0220 - 18.09.2002")
    )
}