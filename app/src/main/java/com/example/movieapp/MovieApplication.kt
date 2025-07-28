package com.example.movieapp

import android.app.Application
import com.example.movieapp.di.apiMapperModule
import com.example.movieapp.di.appModule
import com.example.movieapp.di.movieDetailModule
import com.example.movieapp.di.movieModule
import com.example.movieapp.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MovieApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MovieApplication)
            androidLogger(Level.DEBUG)
            modules(
                apiMapperModule,
                movieDetailModule,
                movieModule,
                networkModule,
                appModule
            )
        }
    }
}