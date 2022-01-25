package org.android.reminiscencewinter

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.android.reminiscencewinter.data.repository.PicsumRoomRepositoryImpl
import org.android.reminiscencewinter.data.source.local.PicsumRoomDatabase
import timber.log.Timber

@HiltAndroidApp
class ReminiscenceApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG){Timber.plant(JuyaeDebugTree())}
    }
    private class JuyaeDebugTree : Timber.DebugTree(){
        override fun createStackElementTag(element: StackTraceElement): String =
            "${element.fileName} : ${element.lineNumber} : ${element.methodName}"
    }
}