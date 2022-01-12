package org.android.reminiscencewinter.domain.repository

import io.reactivex.rxjava3.core.Single
import org.android.reminiscencewinter.domain.entity.MemoryEntity

interface MemoryRepository {
    fun getSpecificPicture(id: Int): Single<MemoryEntity>
}