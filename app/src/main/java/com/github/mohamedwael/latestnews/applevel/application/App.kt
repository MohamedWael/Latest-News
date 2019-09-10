package com.github.mohamedwael.latestnews.applevel.application

import android.app.Application
import com.github.mohamedwael.latestnews.R
import com.github.mohamedwael.latestnews.applevel.BASE_API
import com.github.mohamedwael.latestnews.applevel.network.ApiKetInterceptor
import com.github.mohamedwael.latestnews.applevel.network.Retrofit
import com.github.mohamedwael.latestnews.applevel.storage.StorageManager
import net.danlew.android.joda.JodaTimeAndroid
import okhttp3.OkHttpClient

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Retrofit.init(
            httpClient = OkHttpClient.Builder().addInterceptor(
                ApiKetInterceptor(getString(R.string.news_api_key))
            ),
            baseUrl = BASE_API
        )
        StorageManager.init(this)
        JodaTimeAndroid.init(this)
    }
}