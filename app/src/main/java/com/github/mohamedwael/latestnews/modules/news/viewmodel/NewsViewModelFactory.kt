package com.github.mohamedwael.latestnews.modules.news.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.mohamedwael.latestnews.modules.news.repo.NewsRepoImpl

class NewsViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(NewsRepoImpl()) as T
    }
}