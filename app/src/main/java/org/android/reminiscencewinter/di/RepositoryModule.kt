package org.android.reminiscencewinter.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.android.daangngallery.data.network.RetrofitService
import org.android.reminiscencewinter.data.repository.*
import org.android.reminiscencewinter.data.source.local.PicsumDao
import org.android.reminiscencewinter.data.source.local.PicsumRoomDatabase
import org.android.reminiscencewinter.data.source.remote.MemoryInfoDataSource
import org.android.reminiscencewinter.data.source.remote.paging.PicsumPhotoDataSource
import org.android.reminiscencewinter.domain.repository.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideAlbumRepository(memoryInfoDataSource: MemoryInfoDataSource): MemoryRepository =
        MemoryRepositoryImpl(memoryInfoDataSource)

    @Provides
    @Singleton
    fun providePhotoRepository(retrofitService: RetrofitService) : PhotoRepository =
        PhotoRepositoryImpl(retrofitService)

    @Provides
    @Singleton
    fun providePicsumPhotoRepository(picsumPhotoDataSource: PicsumPhotoDataSource) : PicsumRepository =
        PicsumRepositoryImpl(picsumPhotoDataSource)

    @Provides
    @Singleton
    fun provideStoragePhotoRepository(retrofitService: RetrofitService) : StorageRepository =
        StorageRepositoryImpl(retrofitService)

    @Provides
    @Singleton
    fun provideStorageRoomRepository(database: PicsumRoomDatabase) : PicsumRoomRepositoryImpl=
        PicsumRoomRepositoryImpl(database)

}