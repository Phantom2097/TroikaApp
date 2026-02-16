package ru.phantom2097.troikaapp.presentation.core.app_events

sealed interface NavEvent {
    data object SummaryReselected : NavEvent
}