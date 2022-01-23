package org.android.reminiscencewinter.data.source.local.storage

import io.reactivex.rxjava3.core.Single
import org.android.reminiscencewinter.data.dto.Photo

interface StorageDataSource {
    fun getStoragePhoto(page : Int, limit : Int) : Single<List<Photo>>
}