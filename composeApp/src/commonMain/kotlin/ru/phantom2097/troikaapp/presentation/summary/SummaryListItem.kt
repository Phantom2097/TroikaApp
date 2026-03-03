package ru.phantom2097.troikaapp.presentation.summary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.vectorResource
import ru.phantom2097.troikaapp.presentation.ui.theme.AppTheme
import ru.phantom2097.troikaapp.resources.Res
import ru.phantom2097.troikaapp.resources.alt_arrow_down_outline
import kotlin.repeat

@Composable
fun SummaryListItem(
    modifier: Modifier = Modifier,
    title: String,
    openScreenClickListener: () -> Unit,
    content: @Composable () -> Unit,
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp, horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = title,
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )

            IconButton(
                onClick = {
                    openScreenClickListener()
                },
            ) {
                Icon(
                    modifier = Modifier.rotate(270f),
                    imageVector = vectorResource(Res.drawable.alt_arrow_down_outline),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .padding(4.dp)
                .clip(shape = MaterialTheme.shapes.large)
                .background(MaterialTheme.colorScheme.surfaceContainer)
                .padding(4.dp),
            contentAlignment = Alignment.Center
        ) {
            content()
        }
    }
}

@Preview
@Composable
fun SummaryListItemPreview() {
    AppTheme {
        SummaryListItem(
            title = "Заголовок",
            openScreenClickListener = { }
        ) {
            Column {
                repeat(6) {
                    Text(
                        text = "Тут какой-то экран"
                    )
                }
            }
        }
    }
}