package org.android.reminiscencewinter.data.source.remote.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import kotlinx.coroutines.delay
import org.android.daangngallery.data.network.RetrofitService
import org.android.daangngallery.data.dto.Picsum
import javax.inject.Inject
import kotlin.random.Random

class PicsumPagingSource @Inject constructor(
    private val api : RetrofitService
) : PagingSource<Int, Picsum>() {
    override fun getRefreshKey(state: PagingState<Int, Picsum>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Picsum> {
        return try {
            delay(500)
            if (Random.nextFloat() < 0.5) {
                throw Exception("Error")
            }
            val next = params.key ?: 0
            val response = api.getPicsumImage(page=1, limit=100)

            LoadResult.Page(
                data = response.blockingGet(),
                prevKey = if (next == 0) null else next - 1,
                nextKey = next + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}