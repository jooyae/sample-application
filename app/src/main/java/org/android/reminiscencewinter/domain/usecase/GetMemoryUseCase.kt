package org.android.reminiscencewinter.domain.usecase

import io.reactivex.rxjava3.core.Single
import org.android.daangngallery.data.dto.Album
import org.android.reminiscencewinter.domain.model.AlbumEntity
import org.android.reminiscencewinter.domain.repository.MemoryRepository
import org.android.reminiscencewinter.domain.usecase.base.SingleUseCase
import javax.inject.Inject

class GetMemoryUseCase @Inject constructor(
    private val memoryRepository: MemoryRepository
) {
    operator fun invoke(id: Int) : Single<AlbumEntity> {
        return memoryRepository.getSpecificPicture(id)
    }
}