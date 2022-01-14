package org.android.reminiscencewinter.domain.usecase

import androidx.paging.PagingData
import io.reactivex.rxjava3.core.Flowable
import org.android.reminiscencewinter.domain.model.PhotoEntity
import org.android.reminiscencewinter.domain.repository.PhotoRepository
import javax.inject.Inject

class GetPhotoInfoUseCase @Inject constructor(private val photoRepository: PhotoRepository)
   {
    operator fun invoke(
        initPage: Int,
        limit: Int,
        totalImageCount: Int
    ): Flowable<PagingData<PhotoEntity>> {
        return photoRepository.getPhotos(initPage, limit, totalImageCount)
    }
}