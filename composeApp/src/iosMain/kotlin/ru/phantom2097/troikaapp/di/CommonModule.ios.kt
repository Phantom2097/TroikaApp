package ru.phantom2097.troikaapp.di

import org.koin.core.module.Module
import org.koin.dsl.module
import ru.phantom2097.troikaapp.data.database.getRoomDatabase
import ru.phantom2097.troikaapp.getDatabaseBuilder

actual val commonModule: Module = module {
    single {
        val builder = getDatabaseBuilder()
        getRoomDatabase(builder)
    }
}