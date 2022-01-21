package org.android.reminiscencewinter.presentation.album.viewmodel

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
class AlbumViewModel @Inject constructor(
    private val getPhotoInfoUseCase: GetPhotoInfoUseCase
) : DisposableViewModel(){
    private val _pictures = MutableLiveData<PagingData<PhotoEntity>>()
    val pictures : LiveData<PagingData<PhotoEntity>> = _pictures

    private val _albumInfo = MutableLiveData<AlbumEntity>()
    val albumInfo : LiveData<AlbumEntity> = _albumInfo

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

}