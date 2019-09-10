package com.github.mohamedwael.latestnews.modules.news.viewmodel

import androidx.paging.DataSource
import com.github.mohamedwael.latestnews.modules.news.response.ArticleItem

class FakeReposDataSource : DataSource.Factory<Int, ArticleItem>(){
    override fun create(): DataSource<Int, ArticleItem> {
        return FakeReposDataSource() as DataSource<Int, ArticleItem>
    }
}