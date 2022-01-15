package org.android.reminiscencewinter.domain.usecase

import io.reactivex.rxjava3.core.Single
import org.android.reminiscencewinter.domain.model.MemoryEntity
import org.android.reminiscencewinter.domain.repository.MemoryRepository
import org.android.reminiscencewinter.domain.usecase.base.SingleUseCase
import org.android.reminiscencewinter.domain.usecase.base.UseCase
import javax.inject.Inject

class MemoryInfoUseCase @Inject constructor(
    private val memoryRepository: MemoryRepository
) : SingleUseCase<MemoryEntity, Int>(){
    override fun buildUseCaseSingle(params: Int?): Single<MemoryEntity> {
        return memoryRepository.getSpecificPicture(params ?: -1)
    }
}