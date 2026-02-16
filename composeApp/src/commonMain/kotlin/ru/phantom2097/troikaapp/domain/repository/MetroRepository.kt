package ru.phantom2097.troikaapp.domain.repository

interface MetroRepository {

    suspend fun getTripHistory()
    suspend fun getAmountSpentSum(): Result<Double>

    suspend fun removeTripHistory()

    suspend fun getSubscriptionInfo()

    suspend fun addTripInformation()

    suspend fun removeTripInformation()

    suspend fun updateStationInfo()
}