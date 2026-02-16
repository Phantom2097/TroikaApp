package ru.phantom2097.troikaapp.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "trip"
)
data class TripDescriptionEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "trip_id")
    val tripId: Long = 0,
    val date: String,
    val price: Double,
    val metroStation: String,
)
