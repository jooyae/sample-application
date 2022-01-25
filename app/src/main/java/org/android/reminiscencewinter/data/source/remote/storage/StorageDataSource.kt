package org.android.reminiscencewinter.data.source.remote.storage

import io.reactivex.rxjava3.core.Single
import org.android.reminiscencewinter.data.mapper.dto.Photo

interface StorageDataSource {
    fun getStoragePhoto(page : Int, limit : Int) : Single<List<Photo>>
}