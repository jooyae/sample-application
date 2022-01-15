package org.android.reminiscencewinter.domain.repository

import io.reactivex.rxjava3.core.Single
import org.android.reminiscencewinter.domain.model.GalleryEntity
import org.android.reminiscencewinter.domain.model.PhotoEntity

interface PicsumRepository {
    fun getPhotoList(page : Int, limit : Int): Single<List<PhotoEntity>>
    fun loadAlbumList(page: Int, limit: Int) : Single<List<GalleryEntity>>
}