package ru.phantom2097.troikaapp.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// TODO: Maybe use that api https://dadata.ru/api/suggest/metro/
@Entity
data class MetroStationEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "metro_station_id")
    val metroStationId: Int = 0,
    val stationName: String,
    val lineName: String,
    val lineColor: String,
    val cityName: String,
    val lineId: Int,
    val lat: Int,
    val lon: Int,
    val isClosed: Boolean
)
