package org.android.daangngallery.data.dto

import org.android.reminiscencewinter.domain.model.MemoryEntity
import org.android.reminiscencewinter.domain.model.PhotoEntity


data class Picsum(
    val author: String,
    val download_url: String,
    val height: Int,
    val id: String,
    val url: String,
    val width: Int
){
    fun convertToMemoryEntity(): PhotoEntity {
        return PhotoEntity(
            id = id,
            author = author,
            photo = download_url
        )
    }
}