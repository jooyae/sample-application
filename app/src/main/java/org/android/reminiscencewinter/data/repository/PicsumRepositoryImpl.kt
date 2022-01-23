package org.android.reminiscencewinter.data.repository

import io.reactivex.rxjava3.core.Single
import org.android.reminiscencewinter.data.source.local.paging.PicsumPhotoDataSource
import org.android.reminiscencewinter.domain.model.GalleryEntity
import org.android.reminiscencewinter.domain.model.PhotoEntity
import org.android.reminiscencewinter.domain.repository.PicsumRepository
import javax.inject.Inject

class PicsumRepositoryImpl @Inject constructor(private val picsumPhotoDataSource: PicsumPhotoDataSource) :
    PicsumRepository {

    override fun getPhotoList(page: Int, limit: Int): Single<List<PhotoEntity>> =
        picsumPhotoDataSource.getPhotoList(page, limit).map {
            it.map {
                PhotoEntity(it.id, it.author, it.download_url)
            }
        }

    override fun loadAlbumList(page: Int, limit: Int): Single<List<GalleryEntity>> =
        picsumPhotoDataSource.getPhotoList(page, limit).map {
            it.map {
                GalleryEntity(it.download_url, it.author, it.height)
            }
        }
}