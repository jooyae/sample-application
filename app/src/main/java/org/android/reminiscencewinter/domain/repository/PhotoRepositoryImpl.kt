package org.android.reminiscencewinter.domain.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.rxjava3.flowable
import io.reactivex.rxjava3.core.Flowable
import org.android.daangngallery.data.network.RetrofitService
import org.android.daangngallery.data.source.PicturesPagingSource
import org.android.reminiscencewinter.domain.entity.PhotoEntity
import javax.inject.Inject

class PhotoRepositoryImpl @Inject constructor(
    private val retrofitService: RetrofitService
) : PhotoRepository{
    override fun getPhotos(initPage: Int, size: Int, limit: Int): Flowable<PagingData<PhotoEntity>> {
        return Pager(
            config = PagingConfig(
                pageSize = 1,
                enablePlaceholders = true
            ),
            pagingSourceFactory = {PicturesPagingSource(retrofitService, initPage, size, limit)}
        ).flowable
    }
}