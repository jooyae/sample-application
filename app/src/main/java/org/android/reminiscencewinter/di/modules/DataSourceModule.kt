package org.android.reminiscencewinter.di.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.android.daangngallery.data.network.RetrofitService
import org.android.daangngallery.data.source.AlbumInfoDataSource
import org.android.daangngallery.data.source.AlbumInfoDataSourceImpl
import org.android.daangngallery.data.source.PicsumPhotoDataSource
import org.android.daangngallery.data.source.PicsumPhotoDataSourceImpl
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
    fun provideAlbumInfoDataSource(retrofitService: RetrofitService): AlbumInfoDataSource =
        AlbumInfoDataSourceImpl(retrofitService)
}