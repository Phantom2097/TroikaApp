package ru.phantom2097.troikaapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.phantom2097.troikaapp.data.dao.TripDao
import ru.phantom2097.troikaapp.data.dao.TripPriceDao
import ru.phantom2097.troikaapp.data.database.MetroDatabase.Companion.DATABASE_VERSION
import ru.phantom2097.troikaapp.data.entities.PriceEntity
import ru.phantom2097.troikaapp.data.entities.MetroStationEntity
import ru.phantom2097.troikaapp.data.entities.TripDescriptionEntity
import ru.phantom2097.troikaapp.data.entities.TripPriceEntity

@Database(
    entities = [
        TripDescriptionEntity::class,
        PriceEntity::class,
        MetroStationEntity::class,
        TripPriceEntity::class,
    ],
    version = DATABASE_VERSION
)
abstract class MetroDatabase : RoomDatabase() {
    abstract fun tripDao(): TripDao
    abstract fun tripPriceDao(): TripPriceDao

    companion object {
        const val DATABASE_NAME = "metro_db"
        private const val DATABASE_VERSION = 1
    }
}