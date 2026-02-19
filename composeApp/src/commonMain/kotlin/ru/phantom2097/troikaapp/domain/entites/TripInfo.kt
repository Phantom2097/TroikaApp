package ru.phantom2097.troikaapp.domain.entites

import kotlin.time.Instant

interface TripInfo {
    val time: Instant
    val price: Double
    val station: MetroStation
}