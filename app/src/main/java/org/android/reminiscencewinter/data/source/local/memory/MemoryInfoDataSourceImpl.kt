package org.android.reminiscencewinter.data.source.local.memory

import io.reactivex.rxjava3.core.Single
import org.android.daangngallery.data.network.RetrofitService
import org.android.daangngallery.data.dto.Album
import org.android.reminiscencewinter.data.source.local.memory.MemoryInfoDataSource
import javax.inject.Inject

class MemoryInfoDataSourceImpl @Inject constructor(
    private val retrofitService: RetrofitService
): MemoryInfoDataSource {
    override fun getSpecificPicture(id: Int): Single<Album> =
        retrofitService.getSpecificPicture(id).map { Album(id, it) }
}