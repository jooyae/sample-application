package org.android.reminiscencewinter.presentation.memory.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.rxjava3.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import org.android.reminiscencewinter.domain.model.MemoryEntity
import org.android.reminiscencewinter.domain.model.PhotoEntity
import org.android.reminiscencewinter.domain.usecase.GetPhotoInfoUseCase
import org.android.reminiscencewinter.domain.usecase.MemoryInfoUseCase
import org.android.reminiscencewinter.presentation.util.DisposableViewModel
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel @Inject constructor(
    private val getPhotoInfoUseCase: GetPhotoInfoUseCase,
    private val memoryInfoUseCase: MemoryInfoUseCase
) : DisposableViewModel() {
    private val _albumInfo = MutableLiveData<List<MemoryEntity>>()
    val albumInfo : LiveData<List<MemoryEntity>> = _albumInfo

    private val _album = MutableLiveData<PhotoEntity>()
    val album : LiveData<PhotoEntity> = _album

    private val _photos = MutableLiveData<PagingData<PhotoEntity>>()
    val photos: LiveData<PagingData<PhotoEntity>> = _photos

    init {
        getAlbumInfo()
    }

    private fun getAlbumInfo() {
        val albumIdxList = listOf(10, 30, 50,10,20,30,40,50,20,10,55,32)
        addDisposable(
            Observable.fromIterable(
                albumIdxList
            ).concatMapEager {
                memoryInfoUseCase(it).toObservable()
            }.subscribeOn(Schedulers.io())
                .toList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    _albumInfo.postValue(it)
                }, {
                    it.printStackTrace()
                })
        )
    }

}

