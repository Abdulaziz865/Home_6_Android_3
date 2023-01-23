package com.example.home_6_android_3.hilt.ui.fragments.get_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.home_6_android_3.hilt.data.models.PhotoModel
import com.example.home_6_android_3.hilt.data.repositories.PhotosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GetViewModel @Inject constructor(private val repository: PhotosRepository) : ViewModel() {

    private val _photoLiveData = MutableLiveData<List<PhotoModel>>()
    val photoLiveData: LiveData<List<PhotoModel>> = _photoLiveData

    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> = _errorLiveData

    fun getPhoto() {
        repository.getPhoto(onSuccess = {
            _photoLiveData.value = it
        }, onFailure = {
            _errorLiveData.value = it
        })
    }
}