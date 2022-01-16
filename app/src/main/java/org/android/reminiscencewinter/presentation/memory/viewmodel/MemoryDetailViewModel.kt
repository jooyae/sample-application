package org.android.reminiscencewinter.presentation.memory.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.rxjava3.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import org.android.reminiscencewinter.domain.model.AlbumEntity
import org.android.reminiscencewinter.domain.model.PhotoEntity
import org.android.reminiscencewinter.domain.usecase.GetPhotoInfoUseCase
import org.android.reminiscencewinter.presentation.util.DisposableViewModel
import javax.inject.Inject

@HiltViewModel
class MemoryDetailViewModel @Inject constructor(
    private val getPhotoInfoUseCase: GetPhotoInfoUseCase
) : DisposableViewModel(){

    private val _photoList = MutableLiveData<List<PhotoEntity>>()
    val photoList : LiveData<List<PhotoEntity>>
        get() = _photoList

    private val _selectedPhoto = MutableLiveData<PhotoEntity>()
    val selectedPhoto: LiveData<PhotoEntity> = _selectedPhoto

    private val _albumInfo = MutableLiveData<AlbumEntity>()
    val albumInfo : LiveData<AlbumEntity> = _albumInfo

    private val _pictures = MutableLiveData<PagingData<PhotoEntity>>()
    val pictures : LiveData<PagingData<PhotoEntity>> = _pictures

    fun updateAlbumInfo(album : AlbumEntity) {
        _albumInfo.value = album
    }

    fun getPhotos(){
        getPhotoInfoUseCase(
            albumInfo.value?.albumId?:0,
            20,
            albumInfo.value?.imageCount ?:0
        ).subscribeOn(Schedulers.io())
            .cachedIn(viewModelScope)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                 _pictures.postValue(it)
            },{
                it.printStackTrace()
            })
    }

    fun deletePhoto(){
        val originalPhotoList = photoList.value?.toMutableList()
        val deleteTarget = originalPhotoList?.find { it.id == selectedPhoto.value?.id }
        originalPhotoList?.remove(deleteTarget)
        originalPhotoList?.let { _photoList.value = it }
    }

}