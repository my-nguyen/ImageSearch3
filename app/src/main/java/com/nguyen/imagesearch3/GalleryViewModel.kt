package com.nguyen.imagesearch3

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

private const val DEFAULT_QUERY = "cats"

@HiltViewModel // formerly @ViewModelInject
class GalleryViewModel @Inject constructor(private val repository: Repository): ViewModel() {
    private val query = MutableLiveData(DEFAULT_QUERY)
    // whenever query chances, photos get updated accordingly
    val photos = query.switchMap { string ->
        repository.searchPhotos(string).cachedIn(viewModelScope)
    }

    fun searchPhotos(query: String) {
        this.query.value = query
    }
}