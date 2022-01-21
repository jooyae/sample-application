package org.android.reminiscencewinter.di.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.android.daangngallery.data.network.RetrofitService
import org.android.reminiscencewinter.data.source.local.MemoryInfoDataSource
import org.android.reminiscencewinter.data.source.local.MemoryInfoDataSourceImpl
import org.android.reminiscencewinter.data.source.local.PicsumPhotoDataSource
import org.android.reminiscencewinter.data.source.local.PicsumPhotoDataSourceImpl
import org.android.reminiscencewinter.data.source.local.StorageDataSource
import org.android.reminiscencewinter.data.source.local.StorageDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun providePicSumPhotoController(retrofitService: RetrofitService): PicsumPhotoDataSource =
        PicsumPhotoDataSourceImpl(retrofitService)
    @Provides
    @Singleton
    fun provideAlbumInfoDataSource(retrofitService: RetrofitService): MemoryInfoDataSource =
        MemoryInfoDataSourceImpl(retrofitService)
    @Provides
    @Singleton
    fun provideStoragePhotoController(retrofitService: RetrofitService) : StorageDataSource =
        StorageDataSourceImpl(retrofitService)
}