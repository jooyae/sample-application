package org.android.daangngallery.data.dto

import org.android.reminiscencewinter.domain.entity.PhotoEntity


data class Picsum(
    val author: String,
    val download_url: String,
    val height: Int,
    val id: String,
    val url: String,
    val width: Int
){
    fun convertToPhotoEntity(): PhotoEntity {
        return PhotoEntity(
            id = id,
            author = author,
            photo = download_url
        )
    }
}