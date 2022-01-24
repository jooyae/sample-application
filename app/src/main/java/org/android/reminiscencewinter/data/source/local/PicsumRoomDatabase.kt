package org.android.reminiscencewinter.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Picsum::class],
    version = 1,
    exportSchema = true
)
abstract class PicsumRoomDatabase : RoomDatabase() {
    abstract fun picsumDao() : PicsumDao

    companion object {
        @Volatile
        private var INSTANCE : PicsumRoomDatabase ? = null

        fun getDataBase(context : Context) : PicsumRoomDatabase{
            val tempInstance = INSTANCE

            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PicsumRoomDatabase::class.java,
                    "picsum_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}