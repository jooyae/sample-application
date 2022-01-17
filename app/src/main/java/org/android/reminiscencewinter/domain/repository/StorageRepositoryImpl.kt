package org.android.reminiscencewinter.domain.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.rxjava3.flowable
import io.reactivex.rxjava3.core.Flowable
import org.android.daangngallery.data.network.RetrofitService
import org.android.reminiscencewinter.data.source.remote.PicturesPagingSource
import org.android.reminiscencewinter.data.source.remote.StoragePagingSource
import org.android.reminiscencewinter.domain.model.StorageEntity
import javax.inject.Inject

class StorageRepositoryImpl @Inject constructor(
    private val retrofitService: RetrofitService
) : StorageRepository {
    override fun getStoragePhoto(
        initPage: Int,
        size: Int,
        limit: Int
    ): Flowable<PagingData<StorageEntity>> {
        return Pager(
            config = PagingConfig(
                pageSize = 1,
                enablePlaceholders = true
            ),
            pagingSourceFactory = { StoragePagingSource(retrofitService, initPage, size, limit)}
        ).flowable
    }
}