package org.android.reminiscencewinter.presentation.storage.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.rxjava3.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.launch
import org.android.reminiscencewinter.data.repository.PicsumRoomRepositoryImpl
import org.android.reminiscencewinter.data.source.local.Picsum
import org.android.reminiscencewinter.domain.model.AlbumEntity
import org.android.reminiscencewinter.domain.model.StorageEntity
import org.android.reminiscencewinter.domain.usecase.GetStorageInfoUseCase
import org.android.reminiscencewinter.presentation.util.DisposableViewModel
import javax.inject.Inject

@HiltViewModel
class StorageViewModel @Inject constructor(
    private val getStorageInfoUseCase: GetStorageInfoUseCase,
    private val picsumRoomRepositoryImpl: PicsumRoomRepositoryImpl
) : DisposableViewModel() {

    private val _storage = MutableLiveData<PagingData<StorageEntity>>()
    val storage : LiveData<PagingData<StorageEntity>> = _storage

    private val _albumInfo = MutableLiveData<AlbumEntity>()
    val albumInfo : LiveData<AlbumEntity> = _albumInfo

    val allPicsum : LiveData<List<Picsum>> =
        picsumRoomRepositoryImpl.allPicsum.asLiveData()

    fun getStorage(){
        getStorageInfoUseCase(
            1,
            20,
            30
        ).subscribeOn(Schedulers.io())
            .cachedIn(viewModelScope)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _storage.postValue(it)
            },{
                it.printStackTrace()
            })
    }

    fun update(picsum: Picsum) = viewModelScope.launch {
        picsumRoomRepositoryImpl.update(picsum)
    }
}