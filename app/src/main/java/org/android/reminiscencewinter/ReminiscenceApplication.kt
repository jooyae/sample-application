package org.android.reminiscencewinter

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.android.reminiscencewinter.data.repository.PicsumRoomRepositoryImpl
import org.android.reminiscencewinter.data.source.local.PicsumRoomDatabase

@HiltAndroidApp
class ReminiscenceApplication : Application(){
    override fun onCreate() {
        super.onCreate()
    }
}