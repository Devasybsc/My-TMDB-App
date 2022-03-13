package com.example.mytmdbapp.di

import android.app.Application
import android.content.Context

class DaggerProvider {

    companion object {
        private var appComponent: AppComponent? = null

        @JvmStatic
        fun initComponent(context: Context) {
            appComponent = DaggerAppComponent.builder()
                .context(context)
                .build()
        }

        @JvmStatic
        fun getAppComponent(): AppComponent? {
            return appComponent
        }
    }
}