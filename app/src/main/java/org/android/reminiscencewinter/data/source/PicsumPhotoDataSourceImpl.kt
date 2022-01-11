package org.android.daangngallery.data.source

import io.reactivex.rxjava3.core.Single
import org.android.daangngallery.data.network.RetrofitService
import org.android.daangngallery.data.dto.Picsum
import javax.inject.Inject

class PicsumPhotoDataSourceImpl @Inject constructor(
    private val retrofitService: RetrofitService
) : PicsumPhotoDataSource {
    override fun getPhotoList(page : Int, limit : Int): Single<List<Picsum>> =
        retrofitService.getPicsumImage(page, limit)
}