package ru.phantom2097.troikaapp.data.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import org.koin.core.module.Module
import org.koin.dsl.module
import ru.phantom2097.troikaapp.data.local.data_store.createDataStore

actual val platformDataStoreModule: Module = module {
    single<DataStore<Preferences>> {
        createDataStore(get<Context>())
    }
}