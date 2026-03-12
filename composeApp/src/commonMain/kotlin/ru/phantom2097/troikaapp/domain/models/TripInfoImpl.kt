package ru.phantom2097.troikaapp.domain.models

import ru.phantom2097.troikaapp.domain.entities.MetroStation
import ru.phantom2097.troikaapp.domain.entities.TripInfo
import kotlin.time.Instant

data class TripInfoImpl(
    override val time: Instant,
    override val price: Double,
    override val station: MetroStation,
) : TripInfo
