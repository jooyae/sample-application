package org.android.reminiscencewinter.presentation.memory.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagingData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import org.android.reminiscencewinter.domain.model.AlbumEntity
import org.android.reminiscencewinter.domain.model.PhotoEntity
import org.android.reminiscencewinter.domain.usecase.GetMemoryUseCase
import org.android.reminiscencewinter.presentation.util.DisposableViewModel
import javax.inject.Inject

@HiltViewModel
class MemoryViewModel @Inject constructor(
    private val getMemoryUseCase: GetMemoryUseCase
) : DisposableViewModel() {
    private val _albums = MutableLiveData<List<AlbumEntity>>(listOf())
    val albums: LiveData<List<AlbumEntity>> = _albums

    init {
        getAlbumInfo()
    }

    private fun getAlbumInfo() {
        val albumIdxList = listOf(10, 30, 50, 10, 20, 30, 40, 50, 20, 10, 55, 32)
        addDisposable(
            Observable.fromIterable(
                albumIdxList
            ).concatMapEager {
                getMemoryUseCase(it).toObservable()
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

