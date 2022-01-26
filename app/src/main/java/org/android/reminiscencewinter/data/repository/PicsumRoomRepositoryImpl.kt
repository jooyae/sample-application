package org.android.reminiscencewinter.data.repository

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow
import org.android.reminiscencewinter.data.source.local.Picsum
import org.android.reminiscencewinter.data.source.local.PicsumRoomDatabase
import javax.inject.Inject

class PicsumRoomRepositoryImpl @Inject constructor(private val database : PicsumRoomDatabase) {
    val allPicsum : Flow<List<Picsum>> = database.picsumDao().readAllData()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun update(picsum: Picsum){
        database.picsumDao().updatePicsum(picsum)
    }
}