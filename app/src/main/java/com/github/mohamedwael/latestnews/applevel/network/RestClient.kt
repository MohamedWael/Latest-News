package com.github.mohamedwael.latestnews.applevel.network

import com.github.mohamedwael.latestnews.applevel.EVEY_THING
import com.github.mohamedwael.latestnews.modules.news.response.NewsResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface RestClient {

    @GET(EVEY_THING)
    fun getNews(@QueryMap map: Map<String, String>): Observable<NewsResponse>


}