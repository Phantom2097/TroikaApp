package ru.phantom2097.troikaapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.phantom2097.troikaapp.data.entities.TripPriceEntity

@Dao
interface TripPriceDao {

    @Insert
    suspend fun addPrices(pricesList: List<TripPriceEntity>)

    @Query("""
        SELECT * FROM trip_price
        WHERE dateCreation = (
            SELECT dateCreation FROM trip_price
            ORDER BY dateCreation DESC
            LIMIT 1
        )
    """)
    suspend fun getCurrentPrices(): List<TripPriceEntity>
}