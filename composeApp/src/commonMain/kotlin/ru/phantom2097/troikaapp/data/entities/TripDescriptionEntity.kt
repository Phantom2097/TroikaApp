package ru.phantom2097.troikaapp.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "trip",
    foreignKeys = [
        ForeignKey(
            entity = MetroStationEntity::class,
            parentColumns = ["metro_station_id"],
            childColumns = ["metro_station_id"],
            onDelete = ForeignKey.SET_NULL
        )
    ],
    indices = [
        Index(
            "metro_station_id",
            unique = true
        )
    ]
)

data class TripDescriptionEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "trip_id")
    val tripId: Long = 0,
    val date: String,
    val price: Double,
    @ColumnInfo(name = "metro_station_id") val metroStationId: Long,
)