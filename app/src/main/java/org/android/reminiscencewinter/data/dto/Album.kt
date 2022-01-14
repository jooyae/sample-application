package org.android.daangngallery.data.dto

import com.thedeanda.lorem.LoremIpsum
import org.android.reminiscencewinter.domain.model.MemoryEntity

data class Album (
    val albumId: Int,
    val thumbnailInfo: Picsum?,
    val albumName: String? = LoremIpsum.getInstance().getWords(1, 2),
    val count: Int? = (25..50).random()
) {
    fun convertToAlbumEntity(): MemoryEntity {
        return MemoryEntity(
            albumId = albumId,
            albumName = albumName,
            thumbnail = thumbnailInfo?.convertToPhotoEntity(),
            imageCount = count
        )
    }
}