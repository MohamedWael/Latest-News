package com.github.mohamedwael.latestnews.modules.news.repo

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.github.mohamedwael.latestnews.applevel.ALL
import com.github.mohamedwael.latestnews.applevel.PUBLISHED_AT
import com.github.mohamedwael.latestnews.applevel.QUERY
import com.github.mohamedwael.latestnews.applevel.SORT_BY
import com.github.mohamedwael.latestnews.applevel.network.ErrorHandler
import com.github.mohamedwael.latestnews.applevel.network.ErrorHandlerImpl
import com.github.mohamedwael.latestnews.applevel.network.RestClient
import com.github.mohamedwael.latestnews.applevel.network.networkservice.network
import com.github.mohamedwael.latestnews.applevel.storage.StorageManager
import com.github.mohamedwael.latestnews.modules.news.response.ArticleItem
import com.github.mohamedwael.latestnews.modules.news.response.NewsResponse
import java.lang.Exception

class NewsRepoImpl : NewsRepo {

    override val liveErrorHandler: MutableLiveData<ErrorHandler> = MutableLiveData()


    override fun getNewsDataSource(): DataSource.Factory<Int, ArticleItem> {
        return StorageManager.articlesDataSource.getItemsDataSource()
    }

    override fun getNews() {
        network<NewsResponse> {
            execute(
                createRestClient(RestClient::class.java).getNews(
                    mapOf(Pair(QUERY, ALL), Pair(SORT_BY, PUBLISHED_AT))
                ), {
                    if (it.articles != null) {
                        StorageManager.articlesDataSource.insertAll(it.articles)
                    } else {
                        liveErrorHandler.value = ErrorHandlerImpl(Exception(it.message))
                    }
                }, {
                    liveErrorHandler.value = it
                })
        }
    }
}