package com.jesil.animequest

import android.app.Application
import com.jesil.animequest.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AnimeQuestApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AnimeQuestApp)
            androidLogger()
            modules(appModule)
        }
    }
}