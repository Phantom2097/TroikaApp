package ru.phantom2097.troikaapp.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.phantom2097.troikaapp.data.database.MetroDatabase
import ru.phantom2097.troikaapp.domain.entites.TripInfo
import ru.phantom2097.troikaapp.domain.repository.MetroRepository

class MetroRepositoryImpl(
    database: MetroDatabase,
) : MetroRepository {

    private val metroStationDao = database.tripPriceDao()
    private val tripDao = database.tripDao()

    override fun getTripHistory(): Flow<List<TripInfo>> {
        TODO("Not yet implemented")
    }

    override suspend fun getAmountSpentSum(): Flow<Double> {
        val amountSum = tripDao.getAmountSpentMoneyForTrip()
        return flow{
            emit(amountSum ?: 0.0)
        }
    }

    override suspend fun removeTripHistory() {
        TODO("Not yet implemented")
    }

    override suspend fun getSubscriptionInfo() {
        TODO("Not yet implemented")
    }

    override suspend fun addTripInformation() {
        TODO("Not yet implemented")
    }

    override suspend fun removeTripInformation() {
        TODO("Not yet implemented")
    }

    override suspend fun updateStationInfo() {
        TODO("Not yet implemented")
    }
}