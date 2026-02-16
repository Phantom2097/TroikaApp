package ru.phantom2097.troikaapp.domain.models

import kotlinx.datetime.DateTimeUnit
import ru.phantom2097.troikaapp.domain.entites.MetroStation
import ru.phantom2097.troikaapp.domain.entites.TripInfo

data class TripInfoImpl(
    override val time: DateTimeUnit,
    override val price: Double,
    override val station: MetroStation
) : TripInfo
