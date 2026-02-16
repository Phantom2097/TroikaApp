package ru.phantom2097.troikaapp.presentation.summary.select_date

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DateRangePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.koin.compose.viewmodel.koinViewModel
import ru.phantom2097.troikaapp.presentation.summary.SummaryViewModel

@OptIn(ExperimentalMaterial3ExpressiveApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SelectTargetPeriod(
    onDismissRequest: () -> Unit,
    viewModel: SummaryViewModel = koinViewModel(),
) {
    val datePrickerState = rememberDateRangePickerState()

    DatePickerDialog(
        modifier = Modifier.fillMaxWidth(),
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            Button(
                onClick = {
                    datePrickerState.apply {
                        viewModel.updateSelectedDates(
                            selectedStartDateMillis,
                            selectedEndDateMillis
                        )
                    }
                    onDismissRequest()
                },
            ) {
                Text("Подтвердить")
            }
        },
        dismissButton = {
            OutlinedButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text("Отмена")
            }
        }
    ) {
        DateRangePicker(
            modifier = Modifier,
            state = datePrickerState
        )
    }
}