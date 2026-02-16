package ru.phantom2097.troikaapp.domain.entites

import kotlinx.datetime.DateTimeUnit

interface TripInfo {
    val time: DateTimeUnit
    val price: Double
    val station: MetroStation
}