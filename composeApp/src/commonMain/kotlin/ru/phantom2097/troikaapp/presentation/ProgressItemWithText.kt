package ru.phantom2097.troikaapp.presentation

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.phantom2097.troikaapp.presentation.core.RoundedBoxText

@Composable
fun ProgressItemWithText(subscriptionPrice: Double, currentExpenses: Double) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        val subscriptionPriceFloat = subscriptionPrice.toFloat()
        val currentExpensesFloat = currentExpenses.toFloat()

        val progressBarColor = if (currentExpensesFloat > subscriptionPriceFloat) {
            MaterialTheme.colorScheme.error
        } else {
            MaterialTheme.colorScheme.primary
        }

        val animatedProgress by animateFloatAsState(
            targetValue = (currentExpensesFloat / subscriptionPriceFloat).run { if (this < 0) 1f else this },
            animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
        )

        RoundedBoxText(currentExpenses)

        LinearProgressIndicator(
            modifier = Modifier
                .height(16.dp)
                .weight(1f)
                .padding(4.dp),
            progress = { animatedProgress },
            gapSize = 1.dp,
            color = progressBarColor
        )

        RoundedBoxText(subscriptionPrice)
    }
}