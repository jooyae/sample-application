package org.android.reminiscencewinter.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AlbumEntity (
    val albumId: Int,
    val albumName: String?,
    val thumbnail: PhotoEntity?,
    val imageCount: Int?
): Parcelable