package org.android.reminiscencewinter.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope
import org.android.reminiscencewinter.data.source.local.dao.PicsumDao

@Database(
    entities = [Picsum::class],
    version = 1,
    exportSchema = false
)
abstract class PicsumRoomDatabase : RoomDatabase() {
    abstract fun picsumDao() : PicsumDao

    companion object {
        @Volatile
        private var INSTANCE : PicsumRoomDatabase ? = null

        fun getDataBase(context : Context, scope : CoroutineScope) : PicsumRoomDatabase{
            return INSTANCE ?:
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PicsumRoomDatabase::class.java,
                    "picsum_table"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}