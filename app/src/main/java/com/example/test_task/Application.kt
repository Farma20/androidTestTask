package com.example.test_task

import android.app.Application
import com.example.test_task.Data.Repository.MainRepository

class Application: Application() {
    override fun onCreate() {
        super.onCreate()
        MainRepository.initialize(this)
    }
}