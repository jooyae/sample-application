package org.android.reminiscencewinter.data.source.local.paging

import io.reactivex.rxjava3.core.Single
import org.android.daangngallery.data.network.RetrofitService
import org.android.daangngallery.data.dto.Picsum
import org.android.reminiscencewinter.data.source.local.paging.PicsumPhotoDataSource
import javax.inject.Inject

class PicsumPhotoDataSourceImpl @Inject constructor(
    private val retrofitService: RetrofitService
) : PicsumPhotoDataSource {
    override fun getPhotoList(page : Int, limit : Int): Single<List<Picsum>> =
        retrofitService.getPicsumImage(page, limit)
}