package org.android.reminiscencewinter.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import org.android.reminiscencewinter.domain.entity.PhotoEntity

@Parcelize
data class MemoryEntity (
    val albumId: Int,
    val albumName: String?,
    val thumbnail: PhotoEntity?,
    val imageCount: Int?
): Parcelable