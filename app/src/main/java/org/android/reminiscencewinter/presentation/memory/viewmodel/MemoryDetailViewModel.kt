package org.android.reminiscencewinter.presentation.memory.viewmodel

import dagger.hilt.android.lifecycle.HiltViewModel
import org.android.reminiscencewinter.domain.usecase.GetPhotoInfoUseCase
import org.android.reminiscencewinter.presentation.util.DisposableViewModel
import javax.inject.Inject

@HiltViewModel
class MemoryDetailViewModel @Inject constructor(
    private val getPhotoInfoUseCase: GetPhotoInfoUseCase
) : DisposableViewModel(){


}