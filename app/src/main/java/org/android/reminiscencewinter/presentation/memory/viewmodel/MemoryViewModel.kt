package org.android.reminiscencewinter.presentation.memory.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import org.android.reminiscencewinter.domain.entity.MemoryEntity
import org.android.reminiscencewinter.domain.usecase.MemoryInfoUseCase
import org.android.reminiscencewinter.presentation.util.DisposableViewModel
import javax.inject.Inject

@HiltViewModel
class MemoryViewModel @Inject constructor(private val memoryInfoUseCase: MemoryInfoUseCase) :
    DisposableViewModel() {
    private val _albums = MutableLiveData<List<MemoryEntity>>(listOf())
    val albums: LiveData<List<MemoryEntity>> = _albums

    private val _photoUrl = MutableLiveData<String>()
    val photoUrl : LiveData<String> = _photoUrl

    init {
        getAlbumInfo()
    }



    private fun addAlbum(memory: MemoryEntity) {
        val albumList = albums.value?.toMutableList()
        albumList?.add(memory)
        albumList?.let { _albums.postValue(it) }
    }

    private fun getAlbumInfo() {
        val albumIdxList = listOf(10, 30, 50, 20, 40, 10, 20, 60, 30, 10, 15, 20)
        addDisposable(
            Observable.fromIterable(
                albumIdxList
            ).concatMapEager {
                memoryInfoUseCase(it).toObservable()
            }.subscribeOn(Schedulers.io())
                .toList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    _albums.postValue(it)
                }, {
                    it.printStackTrace()
                })
        )
    }

}