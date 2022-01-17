package org.android.reminiscencewinter.domain.usecase

import androidx.paging.PagingData
import io.reactivex.rxjava3.core.Flowable
import org.android.reminiscencewinter.domain.model.StorageEntity
import org.android.reminiscencewinter.domain.repository.StorageRepository
import javax.inject.Inject

class GetStorageInfoUseCase @Inject constructor(private val storageRepository: StorageRepository) {
    operator fun invoke(
        initPage : Int,
        limit : Int,
        totalImageCount : Int
    ) : Flowable<PagingData<StorageEntity>> {
        return  storageRepository.getStoragePhoto(initPage, limit, totalImageCount)
    }
}