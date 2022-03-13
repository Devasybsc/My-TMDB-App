package com.example.mytmdbapp

import android.app.Application
import com.example.mytmdbapp.di.DaggerAppComponent
import com.example.mytmdbapp.di.DaggerProvider

class TmdApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        DaggerProvider.initComponent(this)
    }
}
