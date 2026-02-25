package ru.phantom2097.troikaapp.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import ru.phantom2097.troikaapp.data.local.data_store.DATA_STORE_FILE_NAME
import ru.phantom2097.troikaapp.data.local.data_store.createDataStore

fun createDataStore(context: Context): DataStore<Preferences> {
    return createDataStore {
        context.filesDir.resolve(DATA_STORE_FILE_NAME).absolutePath
    }
}