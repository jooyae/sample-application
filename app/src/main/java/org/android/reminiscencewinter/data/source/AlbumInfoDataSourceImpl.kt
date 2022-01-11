package org.android.daangngallery.data.source

import io.reactivex.rxjava3.core.Single
import org.android.daangngallery.data.network.RetrofitService
import org.android.daangngallery.data.dto.Album
import javax.inject.Inject

class AlbumInfoDataSourceImpl @Inject constructor(
    private val retrofitService: RetrofitService
): AlbumInfoDataSource {
    override fun getSpecificPicture(id: Int): Single<Album> =
        retrofitService.getSpecificPicture(id).map { Album(id, it) }
}