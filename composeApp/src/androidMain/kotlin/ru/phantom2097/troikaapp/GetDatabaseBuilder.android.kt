package ru.phantom2097.troikaapp

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.phantom2097.troikaapp.data.database.MetroDatabase
import ru.phantom2097.troikaapp.data.database.MetroDatabase.Companion.DATABASE_NAME
import java.io.File

fun getDatabaseBuilder(context: Context): RoomDatabase.Builder<MetroDatabase> {
    val appContext = context.applicationContext
    val databaseFile = File(appContext.filesDir, DATABASE_NAME)

    return Room.databaseBuilder<MetroDatabase>(
        context = appContext,
        name = databaseFile.absolutePath,
    )
}