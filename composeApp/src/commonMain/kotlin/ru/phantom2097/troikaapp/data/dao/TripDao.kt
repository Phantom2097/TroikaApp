package ru.phantom2097.troikaapp.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import ru.phantom2097.troikaapp.data.entities.TripDescriptionEntity

@Dao
interface TripDao {

    @Upsert
    suspend fun upsertTrip(tripDescriptionEntity: TripDescriptionEntity)

    @Delete
    suspend fun deleteTrip(tripDescriptionEntity: TripDescriptionEntity)

    @Query(
        """
            SELECT * FROM trip
        """
    )
    fun getAllTrip(): Flow<List<TripDescriptionEntity>>

    @Query(
        """
            SELECT SUM(price) FROM trip
        """
    )
    suspend fun getAmountSpentMoneyForTrip(): Double?
}