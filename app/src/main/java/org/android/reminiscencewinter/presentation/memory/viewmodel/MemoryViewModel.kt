package org.android.reminiscencewinter.presentation.memory.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import org.android.reminiscencewinter.domain.entity.MemoryEntity
import org.android.reminiscencewinter.presentation.DisposableViewModel
import javax.inject.Inject

@HiltViewModel
class MemoryViewModel @Inject constructor() : DisposableViewModel(){
    private val _albums = MutableLiveData<List<MemoryEntity>>(listOf())
    val albums: LiveData<List<MemoryEntity>> = _albums


    fun addAlbum(memory: MemoryEntity) {
        val albumList = albums.value?.toMutableList()
        albumList?.add(memory)
        albumList?.let{_albums.postValue(it)}
    }


}