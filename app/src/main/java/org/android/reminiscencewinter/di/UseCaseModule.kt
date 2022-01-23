package org.android.reminiscencewinter.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.android.reminiscencewinter.domain.repository.MemoryRepository
import org.android.reminiscencewinter.domain.repository.PhotoRepository
import org.android.reminiscencewinter.domain.repository.StorageRepository
import org.android.reminiscencewinter.domain.usecase.GetPhotoInfoUseCase
import org.android.reminiscencewinter.domain.usecase.GetMemoryUseCase
import org.android.reminiscencewinter.domain.usecase.GetStorageInfoUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideGetAlbumInfoUseCase(memoryRepository: MemoryRepository): GetMemoryUseCase =
        GetMemoryUseCase(memoryRepository)

    @Provides
    @Singleton
    fun provideGetPhotoInfoUseCase(photoRepository: PhotoRepository) : GetPhotoInfoUseCase =
        GetPhotoInfoUseCase(photoRepository)

    @Provides
    @Singleton
    fun provideGetStorageInfoUseCase(storageRepository: StorageRepository) : GetStorageInfoUseCase =
        GetStorageInfoUseCase(storageRepository)

}

