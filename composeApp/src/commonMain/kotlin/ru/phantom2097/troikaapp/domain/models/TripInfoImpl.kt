package ru.phantom2097.troikaapp.domain.models

import ru.phantom2097.troikaapp.domain.entites.MetroStation
import ru.phantom2097.troikaapp.domain.entites.TripInfo
import kotlin.time.Instant

data class TripInfoImpl(
    override val time: Instant,
    override val price: Double,
    override val station: MetroStation,
) : TripInfo
