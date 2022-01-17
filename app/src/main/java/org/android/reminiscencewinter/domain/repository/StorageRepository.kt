package org.android.reminiscencewinter.domain.repository

import androidx.paging.PagingData
import io.reactivex.rxjava3.core.Flowable
import org.android.reminiscencewinter.domain.model.StorageEntity

interface StorageRepository {
    fun getStoragePhoto(initPage : Int, size : Int, limit : Int) : Flowable<PagingData<StorageEntity>>
}