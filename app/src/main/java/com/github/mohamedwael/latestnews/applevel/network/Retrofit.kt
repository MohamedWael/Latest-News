package com.github.mohamedwael.latestnews.applevel.network

import com.github.mohamedwael.latestnews.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

var LOG_TOGGLE = BuildConfig.DEBUG

object Retrofit {

    var httpClient: OkHttpClient.Builder? = null
    private var retrofit: Retrofit? = null


    fun init(
        httpClient: OkHttpClient.Builder = OkHttpClient.Builder(),
        baseUrl: String,
        factory: Converter.Factory = GsonConverterFactory.create()
    ) {
        com.github.mohamedwael.latestnews.applevel.network.Retrofit.httpClient = httpClient
        setUpLogger()
        val builder =
            Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(factory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        retrofit = builder.client(httpClient.build()).build()
    }

    fun <T> createClient(tClass: Class<T>): T {
        return checkNotNull(retrofit) { "You have to call init() method first" }.create(tClass)
    }


    private fun setUpLogger() {
        if (httpClient != null)
            if (LOG_TOGGLE) {
                httpClient!!.addInterceptor(newBodyLogger())
                httpClient!!.addInterceptor(newHeaderLogger())
            }
    }

    private fun newHeaderLogger(): Interceptor {
        return newLogger(HttpLoggingInterceptor.Level.HEADERS)
    }

    private fun newBodyLogger(): HttpLoggingInterceptor {
        return newLogger(HttpLoggingInterceptor.Level.BODY)
    }

    private fun newLogger(level: HttpLoggingInterceptor.Level): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = level
        return loggingInterceptor
    }
}