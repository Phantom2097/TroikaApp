package ru.phantom2097.troikaapp.domain.use_cases

import kotlinx.coroutines.flow.Flow
import ru.phantom2097.troikaapp.domain.repository.MetroRepository

class GetTripHistoryUseCase(
    val repository: MetroRepository
) {
    operator fun invoke() = repository.getTripHistory()

    fun getAmountSum(): Flow<Double> = repository.getAmountSpentSum()
}