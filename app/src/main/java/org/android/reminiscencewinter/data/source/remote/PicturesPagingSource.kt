package org.android.reminiscencewinter.data.source.remote

import androidx.paging.PagingState
import androidx.paging.rxjava3.RxPagingSource
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.android.daangngallery.data.network.RetrofitService
import org.android.reminiscencewinter.domain.model.PhotoEntity

class PicturesPagingSource(
    private val retrofitService: RetrofitService,
    private val initPage: Int,
    private val size: Int,
    private val totalImageLimit: Int,
): RxPagingSource<Int, PhotoEntity>() {
    private var imageCount = 0

    override fun getRefreshKey(state: PagingState<Int, PhotoEntity>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1) ?:
            state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, PhotoEntity>> {
        val nextPage = params.key ?: 1
        val loadSize = if (totalImageLimit >= imageCount + size) {
            size
        } else {
            totalImageLimit - imageCount
        }
        imageCount += size
        return retrofitService.getPicsumImage(nextPage, loadSize)
            .subscribeOn(Schedulers.io())
            .map { it.map { PhotoEntity(it.id, it.author, it.download_url) } }
            .map { toLoadResult(it, nextPage) }
            .onErrorReturn{ LoadResult.Error(it) }

    }

    private fun toLoadResult(data: List<PhotoEntity>, position: Int): LoadResult<Int, PhotoEntity> {
        return LoadResult.Page(
            data = data,
            prevKey = null,
            nextKey = if(imageCount >= totalImageLimit) null else position + 1
        )
    }
}