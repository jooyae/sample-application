package org.android.reminiscencewinter.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.android.reminiscencewinter.data.source.local.PicsumRoomDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context) : PicsumRoomDatabase {
        return Room.databaseBuilder(context, PicsumRoomDatabase::class.java, "database").allowMainThreadQueries().build()
    }
}