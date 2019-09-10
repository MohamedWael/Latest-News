package com.github.mohamedwael.latestnews.modules.news.repo

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.github.mohamedwael.latestnews.applevel.network.ErrorHandler
import com.github.mohamedwael.latestnews.modules.news.response.ArticleItem

interface NewsRepo {

    val liveErrorHandler: MutableLiveData<ErrorHandler>

    fun getNewsDataSource(): DataSource.Factory<Int, ArticleItem>

    fun getNews()

}