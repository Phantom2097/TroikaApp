package ru.phantom2097.troikaapp.presentation.core.app_events.impl

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import ru.phantom2097.troikaapp.presentation.core.app_events.model.AppBottomBarEventBus
import ru.phantom2097.troikaapp.presentation.core.app_events.NavEvent

class AppBottomBarEventBusImpl : AppBottomBarEventBus {
    private val _events = MutableSharedFlow<NavEvent>()
    override val events = _events.asSharedFlow()

    override suspend fun emit(event: NavEvent) {
        _events.emit(event)
    }
}