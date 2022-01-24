package org.android.reminiscencewinter.data.source.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "picsum_table")
data class Picsum(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    @ColumnInfo(name="author") val author : String?,
    @ColumnInfo(name="url") val url : String?
)
