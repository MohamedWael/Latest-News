package com.github.mohamedwael.latestnews.applevel.storage.datasource

import androidx.lifecycle.LiveData
import com.github.mohamedwael.latestnews.applevel.storage.AppDatabase
import com.github.mohamedwael.latestnews.modules.news.response.ArticleItem

class ArticlesDataSource(db: AppDatabase) : DataSource<ArticleItem>(db) {
    override fun insertItem(data: ArticleItem) {
        doAsync { database.articlesDao().insert(data) }
    }

    override fun insertAll(data: List<ArticleItem>) {
        doAsync { database.articlesDao().insertAll(*data.toTypedArray()) }
    }

    override fun update(data: ArticleItem) {
        doAsync { database.articlesDao().update(data) }
    }

    override fun delete(data: ArticleItem) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteAll() {
        doAsync { database.articlesDao().deleteAll() }
    }

    override fun getItems(): LiveData<List<ArticleItem>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun getItemsDataSource(): androidx.paging.DataSource.Factory<Int, ArticleItem> {
        return database.articlesDao().getAllUsersDataSource()
    }

    override fun getItem(): LiveData<ArticleItem> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}