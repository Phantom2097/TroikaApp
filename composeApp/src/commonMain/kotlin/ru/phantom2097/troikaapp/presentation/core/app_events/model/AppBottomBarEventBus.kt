package ru.phantom2097.troikaapp.presentation.core.app_events.model

import kotlinx.coroutines.flow.SharedFlow
import ru.phantom2097.troikaapp.presentation.core.app_events.NavEvent

interface AppBottomBarEventBus {
    val events: SharedFlow<NavEvent>
    suspend fun emit(event: NavEvent)
}