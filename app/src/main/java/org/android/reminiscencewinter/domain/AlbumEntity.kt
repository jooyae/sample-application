package org.android.reminiscencewinter.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import org.android.reminiscencewinter.domain.entity.PhotoEntity

@Parcelize
data class AlbumEntity (
    val albumId: Int,
    val albumName: String?,
    val thumbnail: PhotoEntity?,
    val imageCount: Int?
): Parcelable