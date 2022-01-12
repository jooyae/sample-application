package org.android.reminiscencewinter.di.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.android.daangngallery.data.source.MemoryInfoDataSource
import org.android.reminiscencewinter.domain.repository.MemoryRepository
import org.android.reminiscencewinter.domain.repository.MemoryRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideAlbumRepository(memoryInfoDataSource: MemoryInfoDataSource): MemoryRepository =
        MemoryRepositoryImpl(memoryInfoDataSource)

}