package org.android.reminiscencewinter.data.source.remote

import io.reactivex.rxjava3.core.Single
import org.android.daangngallery.data.dto.Album

interface MemoryInfoDataSource {
    fun getSpecificPicture(id: Int): Single<Album>
}