package org.android.reminiscencewinter.domain.repository

import io.reactivex.rxjava3.core.Single
import org.android.daangngallery.data.source.MemoryInfoDataSource
import org.android.reminiscencewinter.domain.model.MemoryEntity
import javax.inject.Inject

class MemoryRepositoryImpl @Inject constructor(
    private val memoryInfoDataSource: MemoryInfoDataSource
): MemoryRepository {
    override fun getSpecificPicture(id: Int): Single<MemoryEntity> =
        memoryInfoDataSource.getSpecificPicture(id).map {
            it.convertToAlbumEntity()
        }
}