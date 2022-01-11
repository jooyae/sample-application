package org.android.reminiscencewinter

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ReminiscenceApplication : Application(){
    override fun onCreate() {
        super.onCreate()
    }
}