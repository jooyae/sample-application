package org.android.reminiscencewinter.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StorageEntity(
    val id : String,
    val author : String,
    val photo : String
) : Parcelable