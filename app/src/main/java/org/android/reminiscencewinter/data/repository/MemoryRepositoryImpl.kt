package org.android.reminiscencewinter.data.repository

import io.reactivex.rxjava3.core.Single
import org.android.reminiscencewinter.data.source.local.memory.MemoryInfoDataSource
import org.android.reminiscencewinter.domain.model.AlbumEntity
import org.android.reminiscencewinter.domain.repository.MemoryRepository
import javax.inject.Inject

class MemoryRepositoryImpl @Inject constructor(
    private val memoryInfoDataSource: MemoryInfoDataSource
): MemoryRepository {
    override fun getSpecificPicture(id: Int): Single<AlbumEntity> =
        memoryInfoDataSource.getSpecificPicture(id).map {
            it.convertToAlbumEntity()
        }
}