package ru.phantom2097.troikaapp.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "trip_price"
)
data class TripPriceEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "trip_price_id")
    val tripPriceId: Int = 0,
    val name: String,
    val price: Double,
    val duration: Int,
    val dateCreation: String,
)
