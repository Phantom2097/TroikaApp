package ru.phantom2097.troikaapp.data.repository

import ru.phantom2097.troikaapp.data.database.MetroDatabase
import ru.phantom2097.troikaapp.domain.repository.MetroRepository

class MetroRepositoryImpl(
    database: MetroDatabase,
) : MetroRepository {

    private val metroStationDao = database.tripPriceDao()
    private val tripDao = database.tripDao()

    override suspend fun getTripHistory() {
        TODO("Not yet implemented")
    }

    override suspend fun getAmountSpentSum(): Result<Double> {
        val amountSum = tripDao.getAmountSpentMoneyForTrip()
        val result = if (amountSum != null) {
            Result.success(amountSum)
        } else {
            Result.failure(NumberFormatException("Нет записанных поездок"))
        }
        return result
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