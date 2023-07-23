package com.nguyen.imagesearch3

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel // formerly @ViewModelInject
class GalleryViewModel @Inject constructor(private val repository: Repository): ViewModel() {
}