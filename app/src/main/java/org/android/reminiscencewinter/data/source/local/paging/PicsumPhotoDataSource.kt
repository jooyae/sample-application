package org.android.reminiscencewinter.data.source.local.paging

import io.reactivex.rxjava3.core.Single
import org.android.daangngallery.data.dto.Picsum

interface PicsumPhotoDataSource {
    fun getPhotoList(page : Int, limit : Int) : Single<List<Picsum>>
}
