package ru.phantom2097.troikaapp.presentation.summary

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.vectorResource
import ru.phantom2097.troikaapp.presentation.ui.theme.AppTheme
import ru.phantom2097.troikaapp.resources.Res
import ru.phantom2097.troikaapp.resources.outline_edit_calendar_24

@Composable
fun TopScreenItem(
    modifier: Modifier = Modifier,
    startDate: String,
    endDate: String,
    allSum: String,
    datePickerListener: () -> Unit,
    loadDataListener: () -> Unit,
) {
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

            CurrentWastedSum(allSum)

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
                Icon(
                    imageVector = vectorResource(Res.drawable.outline_edit_calendar_24),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "$startDate - $endDate",
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }

            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

@Preview
@Composable
private fun TopScreenItemPreview() {
    AppTheme {
        TopScreenItem(
            startDate = "19.06.1940",
            endDate = "28.06.1988",
            allSum = "60000",
            datePickerListener = { }
        ) { }
    }
}