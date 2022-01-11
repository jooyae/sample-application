package org.android.reminiscencewinter.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

class MainFrameViewModel : ViewModel() {
    private val _pageIndex: MutableLiveData<Int> = MutableLiveData(0)
    val pageIndex: LiveData<Int>
        get() = _pageIndex

    fun changePageIdx(idx: Int) {
        if (pageIndex.value != idx) _pageIndex.value = idx
    }
}