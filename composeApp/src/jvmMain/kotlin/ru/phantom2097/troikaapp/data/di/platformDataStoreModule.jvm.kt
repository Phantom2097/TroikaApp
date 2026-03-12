package ru.phantom2097.troikaapp.data.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import org.koin.dsl.module
import ru.phantom2097.troikaapp.data.local.data_store.createDataStore

actual val platformDataStoreModule = module {
    single<DataStore<Preferences>> {
        createDataStore()
    }
}