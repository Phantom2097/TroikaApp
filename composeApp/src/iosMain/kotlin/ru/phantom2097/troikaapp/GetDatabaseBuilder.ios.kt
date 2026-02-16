package ru.phantom2097.troikaapp

import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask
import ru.phantom2097.troikaapp.data.database.MetroDatabase
import ru.phantom2097.troikaapp.data.database.MetroDatabase.Companion.DATABASE_NAME

fun getDatabaseBuilder() : RoomDatabase.Builder<MetroDatabase> {
    val databaseFilePath = documentDirectory() + "/$DATABASE_NAME"

    return Room.databaseBuilder<MetroDatabase>(
        name = databaseFilePath,
    )
}

@OptIn(ExperimentalForeignApi::class)
private fun documentDirectory(): String {
    val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
        directory = NSDocumentDirectory,
        inDomain = NSUserDomainMask,
        appropriateForURL = null,
        create = false,
        error = null,
    )

    return requireNotNull(documentDirectory?.path)
}