package ru.phantom2097.troikaapp.data.mappers

import ru.phantom2097.troikaapp.data.relation.TripInfoRelation
import ru.phantom2097.troikaapp.domain.entites.TripInfo
import ru.phantom2097.troikaapp.domain.models.MetroStationImpl
import ru.phantom2097.troikaapp.domain.models.TripInfoImpl
import kotlin.time.Instant

object TripMapper {

    fun TripInfoRelation.toTripInfo(): TripInfo = TripInfoImpl(
        time = Instant.parse(tripDescription.date),
        price = tripDescription.price,
        station = MetroStationImpl(
            stationName = metroStation.stationName,
            lineNum = metroStation.lineId,
            lineColor = metroStation.lineColor,
            lineName = metroStation.lineName,
            isOpen = metroStation.isClosed
        )
    )
}