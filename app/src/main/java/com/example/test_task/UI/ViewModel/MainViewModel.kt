package com.example.test_task.UI.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test_task.Data.Repository.MainRepository
import com.example.test_task.UI.Model.PostModel

class MainViewModel: ViewModel() {
    private val repository = MainRepository.get()
    var allPosts = MutableLiveData<List<PostModel>>(listOf())

    init {
        repository.allPosts.observeForever{
            allPosts.value = it
        }
    }
}