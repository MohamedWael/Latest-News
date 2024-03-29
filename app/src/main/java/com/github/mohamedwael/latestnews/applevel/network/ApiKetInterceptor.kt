package com.github.mohamedwael.latestnews.applevel.network

import okhttp3.Interceptor
import okhttp3.Response
import com.github.mohamedwael.latestnews.applevel.API_KEY


class ApiKetInterceptor(val apiKey: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url()

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter(API_KEY, apiKey)
            .build()

        val requestBuilder = original.newBuilder()
            .url(url)

        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}