package ru.phantom2097.troikaapp.application

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import ru.phantom2097.troikaapp.data.di.repositoryModule
import ru.phantom2097.troikaapp.di.commonModule
import ru.phantom2097.troikaapp.domain.di.useCasesModule
import ru.phantom2097.troikaapp.presentation.di.summaryModule

class SubscriptionBenefitsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin(
            appDeclaration = {
                androidContext(this@SubscriptionBenefitsApplication)
            }
        )
    }
}

private fun initKoin(appDeclaration: KoinAppDeclaration) {
    startKoin {
        appDeclaration()
        modules(
            commonModule,
            useCasesModule,
            repositoryModule,
            summaryModule
        )
    }
}