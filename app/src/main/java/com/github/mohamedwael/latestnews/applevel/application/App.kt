package com.github.mohamedwael.latestnews.applevel.application

import android.app.Application
import com.github.mohamedwael.latestnews.applevel.BASE_API
import com.github.mohamedwael.latestnews.applevel.network.Retrofit
import com.github.mohamedwael.latestnews.applevel.storage.StorageManager

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Retrofit.init(BASE_API)
        StorageManager.init(this)
    }
}