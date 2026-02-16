package ru.phantom2097.troikaapp.di

import org.koin.core.context.startKoin
import ru.phantom2097.troikaapp.data.di.repositoryModule
import ru.phantom2097.troikaapp.domain.di.useCasesModule
import ru.phantom2097.troikaapp.presentation.di.summaryModule

internal fun initKoin() {
    startKoin {
        modules(
            commonModule,
            useCasesModule,
            repositoryModule,
            summaryModule
        )
    }
}