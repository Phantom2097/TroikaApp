package ru.phantom2097.troikaapp

import androidx.room.Room
import androidx.room.RoomDatabase
import ru.phantom2097.troikaapp.data.database.MetroDatabase
import ru.phantom2097.troikaapp.data.database.MetroDatabase.Companion.DATABASE_NAME
import java.io.File

fun getDatabaseBuilder(): RoomDatabase.Builder<MetroDatabase> {
    val databaseFile = File(System.getProperty("java.io.tmpdir"), DATABASE_NAME)

    return Room.databaseBuilder<MetroDatabase>(
        name = databaseFile.absolutePath,
    )
}