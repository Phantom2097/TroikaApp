package ru.phantom2097.troikaapp.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.phantom2097.troikaapp.domain.entities.date_period.DateFormatSettings

interface DatePeriodRepository {
    fun getDatePeriod(): Flow<Pair<String, String>> // need refactor

    suspend fun setDatePeriod()

    fun getDateFormatSettings(): Flow<DateFormatSettings>

    suspend fun setDateFormatSettings()
}