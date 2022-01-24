package org.android.reminiscencewinter.data.source.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface PicsumDao{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPicsum(picsum: Picsum)

    @Update
    suspend fun updatePicsum(picsum: Picsum)

    @Delete
    suspend fun deletePicsum(picsum: Picsum)

    @Query("SELECT * from picsum_table ORDER BY id ASC")
    fun readAllData() : Flow<List<Picsum>>
}
