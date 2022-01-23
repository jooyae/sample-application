package org.android.reminiscencewinter.data.source.remote.storage

import androidx.paging.PagingState
import androidx.paging.rxjava3.RxPagingSource
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.android.daangngallery.data.network.RetrofitService
import org.android.reminiscencewinter.domain.model.StorageEntity

class StoragePagingSource(private val retrofitService: RetrofitService,
                          private val initPage: Int,
                          private val size: Int,
                          private val totalImageLimit: Int,
): RxPagingSource<Int, StorageEntity>() {
    private var imageCount = 0

    override fun getRefreshKey(state: PagingState<Int, StorageEntity>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1) ?:
            state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, StorageEntity>> {
        val nextPage = params.key ?: initPage
        val loadSize = if (totalImageLimit >= imageCount + size) {
            size
        } else {
            totalImageLimit - imageCount
        }
        imageCount += size
        return retrofitService.getPhoto(nextPage, loadSize)
            .subscribeOn(Schedulers.io())
            .map { it.map { StorageEntity(it.id, it.author, it.downloadUrl) } }
            .map { toLoadResult(it, nextPage) }
            .onErrorReturn{ LoadResult.Error(it) }

    }

    private fun toLoadResult(data: List<StorageEntity>, position: Int): LoadResult<Int, StorageEntity> {
        return LoadResult.Page(
            data = data,
            prevKey = null,
            nextKey = if(imageCount >= totalImageLimit) null else position + 1
        )
    }
}