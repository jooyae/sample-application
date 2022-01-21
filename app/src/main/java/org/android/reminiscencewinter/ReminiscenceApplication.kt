package org.android.reminiscencewinter

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ReminiscenceApplication : Application(){
    override fun onCreate() {
        super.onCreate()
    }
    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
    }
}