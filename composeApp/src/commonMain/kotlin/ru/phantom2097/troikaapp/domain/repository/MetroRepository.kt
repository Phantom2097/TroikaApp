package ru.phantom2097.troikaapp.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.phantom2097.troikaapp.domain.entites.TripInfo

interface MetroRepository {

    fun getTripHistory(): Flow<List<TripInfo>>
    suspend fun getAmountSpentSum(): Flow<Double>

    suspend fun removeTripHistory()

    suspend fun getSubscriptionInfo() // add Flow

    suspend fun addTripInformation()

    suspend fun removeTripInformation()

    suspend fun updateStationInfo()
}