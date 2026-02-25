package ru.phantom2097.troikaapp.data.relation

import androidx.room.Embedded
import androidx.room.Relation
import ru.phantom2097.troikaapp.data.entities.MetroStationEntity
import ru.phantom2097.troikaapp.data.entities.TripDescriptionEntity

data class TripInfoRelation(
    @Embedded
    val tripDescription: TripDescriptionEntity,

    @Relation(
        parentColumn = "metro_station_id",
        entityColumn = "metro_station_id"
    )
    val metroStation: MetroStationEntity
)