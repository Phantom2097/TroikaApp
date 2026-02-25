package ru.phantom2097.troikaapp.data.di

import org.koin.dsl.module
import ru.phantom2097.troikaapp.data.repository.MetroRepositoryImpl
import ru.phantom2097.troikaapp.domain.repository.MetroRepository

val repositoryModule = module {
    single<MetroRepository> {
        MetroRepositoryImpl(
            get()
        )
    }
}