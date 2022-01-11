package org.android.daangngallery.data.source

import io.reactivex.rxjava3.core.Single
import org.android.daangngallery.data.dto.Album

interface AlbumInfoDataSource {
    fun getSpecificPicture(id: Int): Single<Album>
}