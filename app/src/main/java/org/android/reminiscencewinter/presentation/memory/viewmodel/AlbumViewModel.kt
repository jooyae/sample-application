package org.android.reminiscencewinter.presentation.memory.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.rxjava3.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import org.android.reminiscencewinter.domain.model.MemoryEntity
import org.android.reminiscencewinter.domain.model.PhotoEntity
import org.android.reminiscencewinter.domain.usecase.GetPhotoInfoUseCase
import org.android.reminiscencewinter.presentation.util.DisposableViewModel
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel @Inject constructor(
    private val getPhotoInfoUseCase: GetPhotoInfoUseCase
) : DisposableViewModel() {
    private val _albumInfo = MutableLiveData<MemoryEntity>()
    val albumInfo : LiveData<MemoryEntity> = _albumInfo

    private val _photos = MutableLiveData<PagingData<PhotoEntity>>()
    val photos: LiveData<PagingData<PhotoEntity>> = _photos

    fun updateAlbumInfo(memory: MemoryEntity) {
        _albumInfo.value = memory
    }

    fun getPictures() {
        getPhotoInfoUseCase(
            albumInfo.value?.albumId ?: 0,
            20,
            albumInfo.value?.imageCount ?: 0
        ).subscribeOn(Schedulers.io())
            .cachedIn(viewModelScope)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _photos.postValue(it)
            }, {
                it.printStackTrace()
            })
    }

}