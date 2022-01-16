package org.android.reminiscencewinter.presentation.memory.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import org.android.reminiscencewinter.domain.model.PhotoEntity
import org.android.reminiscencewinter.domain.repository.PhotoRepository
import org.android.reminiscencewinter.domain.repository.PicsumRepository
import org.android.reminiscencewinter.presentation.util.DisposableViewModel
import javax.inject.Inject

@HiltViewModel
class EditPhotoViewModel @Inject constructor(
    private val picsumRepository: PicsumRepository) :
    DisposableViewModel() {

    private val _selectedPhoto = MutableLiveData<PhotoEntity>()
    val selectedPhoto: LiveData<PhotoEntity> = _selectedPhoto

    private val _photoAuthor = MutableLiveData<String>()
    val photoAuthor: LiveData<String>
        get() = _photoAuthor

    private val _photoUrl = MutableLiveData<String>()
    val photoUrl: LiveData<String>
        get() = _photoUrl

    fun changeSelectedPhoto(photo: PhotoEntity) {
        _selectedPhoto.value = photo
    }
    fun transferPhotoAuthor(author : String){
        _photoAuthor.value = author
    }

    fun transferPhotoUrl(url : String){
        _photoUrl.value = url
    }



}