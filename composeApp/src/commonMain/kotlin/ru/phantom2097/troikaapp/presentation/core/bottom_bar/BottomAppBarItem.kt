package ru.phantom2097.troikaapp.presentation.core.bottom_bar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShortNavigationBar
import androidx.compose.material3.ShortNavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavKey
import ru.phantom2097.troikaapp.presentation.core.ui.CrossfadeIcon
import ru.phantom2097.troikaapp.presentation.core.ui.CrossfadeIconDefaults

// TODO: rename function
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun BottomAppBarItem(
    selectedKey: NavKey,
    onClick: (NavKey) -> Unit,
) {

    val backgroundColor = MaterialTheme.colorScheme.background
    val backgroundBrush = remember(backgroundColor) {
        Brush.verticalGradient(
            colorStops = arrayOf(
                0.0f to Color.Transparent, 0.5f to backgroundColor
            )
        )
    }

    ShortNavigationBar(
        modifier = Modifier.background(
            brush = backgroundBrush
        ), containerColor = Color.Transparent
    ) {
        Row(
            modifier = Modifier.padding(4.dp).background(
                color = MaterialTheme.colorScheme.surfaceContainerHighest,
                shape = MaterialTheme.shapes.extraExtraLarge
            ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            AppTabs.entries.forEach { item ->
                val itemRoute = item.route
                val isSelectedKey = selectedKey == itemRoute
                ShortNavigationBarItem(
                    selected = selectedKey == itemRoute,
                    onClick = {
                        onClick(itemRoute)
                    }, icon = {
                        CrossfadeIcon(
                            isSelectedIcon = isSelectedKey,
                            iconSelected = item.iconBold,
                            iconUnselected = item.iconOutline,
                            description = item.description,
                            colors = CrossfadeIconDefaults.colors(
                                selectedIconColor = MaterialTheme.colorScheme.primary,
                                unSelectedIconColor = MaterialTheme.colorScheme.onSecondaryContainer
                            )
                        )
                    }, label = {
                        Text(
                            text = item.label,
                            color = if (isSelectedKey) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSecondaryContainer,
                            fontSize = 14.sp
                        )
                    }
                )
            }
        }
    }
}