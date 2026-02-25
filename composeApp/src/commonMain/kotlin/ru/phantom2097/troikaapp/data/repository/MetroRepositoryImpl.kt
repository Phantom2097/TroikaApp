package ru.phantom2097.troikaapp.data.repository

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapLatest
import ru.phantom2097.troikaapp.data.database.MetroDatabase
import ru.phantom2097.troikaapp.data.mappers.TripMapper.toTripInfo
import ru.phantom2097.troikaapp.domain.entites.TripInfo
import ru.phantom2097.troikaapp.domain.repository.MetroRepository

class MetroRepositoryImpl(
    database: MetroDatabase,
) : MetroRepository {

    private val metroStationDao = database.tripPriceDao()
    private val tripDao = database.tripDao()

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun getTripHistory(): Flow<List<TripInfo>> {
        return tripDao.getAllTrip().mapLatest { list ->
            list.map { it.toTripInfo() }
        }
    }

    override fun getAmountSpentSum(): Flow<Double> {
        return tripDao.getAmountSpentMoneyForTrip().map {
            it ?: 0.0
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