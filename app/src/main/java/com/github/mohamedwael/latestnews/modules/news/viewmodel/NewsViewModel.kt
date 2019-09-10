package com.github.mohamedwael.latestnews.modules.news.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.github.mohamedwael.latestnews.applevel.ITEMS_PER_PAGE
import com.github.mohamedwael.latestnews.applevel.network.ErrorHandler
import com.github.mohamedwael.latestnews.modules.news.repo.NewsRepo
import com.github.mohamedwael.latestnews.modules.news.response.ArticleItem

class NewsViewModel(private val newsRepo: NewsRepo) : ViewModel() {

    val showProgress = ObservableField(false)

    val errorHandler: LiveData<ErrorHandler>
        get() = newsRepo.liveErrorHandler


    val liveNewsList: LiveData<PagedList<ArticleItem>> = LivePagedListBuilder(
        newsRepo.getNewsDataSource(),
        PagedList.Config.Builder().setInitialLoadSizeHint(ITEMS_PER_PAGE).setPageSize(ITEMS_PER_PAGE).setPrefetchDistance(
            18
        ).setEnablePlaceholders(
            true
        ).build()
    ).build()

    fun getNews(){
        showProgress.set(true)
        newsRepo.getNews()
    }

    fun hideProgress() {
        showProgress.set(false)
    }
}
