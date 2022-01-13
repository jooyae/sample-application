package org.android.reminiscencewinter.domain.repository

import androidx.paging.PagingData
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.flow.Flow
import org.android.reminiscencewinter.domain.entity.PhotoEntity

interface PhotoRepository {
    fun getPhotos(initPage : Int, size : Int, limit : Int): Flowable<PagingData<PhotoEntity>>
}