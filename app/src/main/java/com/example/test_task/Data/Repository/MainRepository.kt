package com.example.test_task.Data.Repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test_task.Data.WebData.MyRetrofit
import com.example.test_task.UI.Model.PostModel
import kotlinx.coroutines.launch


class MainRepository private constructor(context: Context): ViewModel() {

    val allPosts = MutableLiveData<List<PostModel>>().apply {
        this.value = listOf()
    }
    private fun getAllPostFromServer(){
        viewModelScope.launch {
            try {
                allPosts.postValue(MyRetrofit.retrofitService.getAllPosts())
            }catch (e:Exception){
                println(e)
            }
        }
    }

    init {
        getAllPostFromServer()
    }

    companion object{
        private var INSTANCE:MainRepository? = null

        fun initialize(context: Context){
            if(INSTANCE == null){
                INSTANCE = MainRepository(context)
            }
        }

        fun get():MainRepository{
            return INSTANCE?:throw IllegalStateException("Repository must be initialized")
        }

    }
}