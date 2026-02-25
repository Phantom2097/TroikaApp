package ru.phantom2097.troikaapp.view_model

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.TimeZone
import kotlinx.datetime.minus
import ru.phantom2097.troikaapp.domain.entites.TripInfo
import ru.phantom2097.troikaapp.domain.models.MetroStationImpl
import ru.phantom2097.troikaapp.domain.models.TripInfoImpl
import ru.phantom2097.troikaapp.domain.repository.MetroRepository
import kotlin.random.Random
import kotlin.time.Clock

internal class TestRepository : MetroRepository {

    private val _tripListState = MutableStateFlow<List<TripInfo>>(emptyList())
    private val _amountSum = MutableStateFlow<Double>(0.0)

    private val metroStation = MetroStationImpl(
        stationName = "TestStation",
        lineNum = 0,
        lineColor = 100,
        lineName = "Линия 0",
        isOpen = Random.nextBoolean()
    )

    init {
        generateTripHistory()
    }

    override fun getTripHistory(): Flow<List<TripInfo>> {
        return _tripListState.asStateFlow()
    }

    override fun getAmountSpentSum(): Flow<Double> {
        return _amountSum.asStateFlow()
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

    private fun generateTripHistory() {
        val currentTime = Clock.System.now()
        val list = mutableListOf<TripInfo>()
        repeat(10) {

            val randomOffset = Random.nextLong(0, 10)
            val tripTime =
                currentTime.minus(randomOffset, DateTimeUnit.DAY, TimeZone.currentSystemDefault())

            list.add(
                TripInfoImpl(
                    time = tripTime,
                    price = Random.nextDouble(0.0, 200.0),
                    station = metroStation
                )
            )
        }
        _tripListState.update {
            list
        }
    }

    fun emitAmountSum(value: Double) {
        _amountSum.value = value
    }
}