package ru.phantom2097.troikaapp.presentation.summary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialExpressiveTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.vectorResource
import ru.phantom2097.troikaapp.resources.Res
import ru.phantom2097.troikaapp.resources.virtual_troykas
import ru.phantom2097.troikaapp.resources.znak_rublya1

@Composable
fun CurrentWastedSum(allSum: String) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.primary)
            .padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.padding(4.dp),
                imageVector = vectorResource(Res.drawable.virtual_troykas),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSecondary
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                modifier = Modifier
                    .padding(4.dp),
                text = allSum,
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.onPrimary
            )

            Icon(
                modifier = Modifier
                    .size(32.dp),
                imageVector = vectorResource(Res.drawable.znak_rublya1),
                contentDescription = "Рублей",
                tint = MaterialTheme.colorScheme.onSecondary
            )
        }
    }
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Preview
@Composable
private fun CurrentWastedSumPreview() {
    MaterialExpressiveTheme {
        CurrentWastedSum(allSum = "5000")
    }
}