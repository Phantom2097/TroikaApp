package ru.phantom2097.troikaapp.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PriceEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "price_id")
    val priceId: Long = 0,
    val oneTrip: Double,
    val timeTicket: Double, // 90 minutes
    val zone1: Double,
    val zone2: Double,
    val days30: Double,
    val days90: Double,
    val days365: Double,
    val biometry: Double,
    val bankCard: Double,
)