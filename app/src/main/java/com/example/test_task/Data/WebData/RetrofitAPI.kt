package com.example.test_task.Data.WebData

import com.example.test_task.UI.Model.PostModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitAPI {
    @GET("/posts")
    suspend fun getAllPosts():List<PostModel>
}