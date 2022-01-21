package org.android.reminiscencewinter.data.source.local

import io.reactivex.rxjava3.core.Single
import org.android.daangngallery.data.network.RetrofitService
import org.android.reminiscencewinter.data.dto.Photo
import org.android.reminiscencewinter.data.source.local.StorageDataSource
import javax.inject.Inject

class StorageDataSourceImpl @Inject constructor(
    private val retrofitService: RetrofitService
) : StorageDataSource {
    override fun getStoragePhoto(page : Int, limit : Int): Single<List<Photo>> =
        retrofitService.getPhoto(page, limit)
}