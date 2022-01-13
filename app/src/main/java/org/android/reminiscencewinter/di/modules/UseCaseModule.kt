package org.android.reminiscencewinter.di.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.android.reminiscencewinter.domain.repository.MemoryRepository
import org.android.reminiscencewinter.domain.repository.PhotoRepository
import org.android.reminiscencewinter.domain.usecase.GetPhotoInfoUseCase
import org.android.reminiscencewinter.domain.usecase.MemoryInfoUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideGetAlbumInfoUseCase(memoryRepository: MemoryRepository): MemoryInfoUseCase =
        MemoryInfoUseCase(memoryRepository)

    @Provides
    @Singleton
    fun provideGetPhotoInfoUseCase(photoRepository: PhotoRepository) : GetPhotoInfoUseCase =
        GetPhotoInfoUseCase(photoRepository)
}

