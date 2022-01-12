package org.android.reminiscencewinter.domain.usecase

import io.reactivex.rxjava3.core.Single
import org.android.reminiscencewinter.domain.entity.MemoryEntity
import org.android.reminiscencewinter.domain.repository.MemoryRepository
import javax.inject.Inject

class MemoryInfoUseCase @Inject constructor(
    private val memoryRepository: MemoryRepository
) {
    operator fun invoke(id: Int) : Single<MemoryEntity>{
        return memoryRepository.getSpecificPicture(id)
    }
}