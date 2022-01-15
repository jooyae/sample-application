package org.android.reminiscencewinter.domain.repository

import androidx.paging.PagingData
import io.reactivex.rxjava3.core.Flowable
import org.android.reminiscencewinter.domain.model.PhotoEntity

interface PhotoRepository {
    fun getPhotos(initPage : Int, size : Int, limit : Int): Flowable<PagingData<PhotoEntity>>
}