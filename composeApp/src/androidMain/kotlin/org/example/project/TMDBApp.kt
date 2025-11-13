package org.example.project

import android.app.Application
import org.example.project.di.sharedModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class TMDBApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@TMDBApp)
            modules(sharedModule)
        }
    }
}