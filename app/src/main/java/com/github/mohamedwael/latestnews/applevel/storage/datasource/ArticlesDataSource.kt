package com.github.mohamedwael.latestnews.applevel.storage.datasource

import androidx.lifecycle.LiveData
import com.github.mohamedwael.latestnews.applevel.storage.AppDatabase
import com.github.mohamedwael.latestnews.modules.response.ArticlesItem

class ArticlesDataSource(db: AppDatabase) : DataSource<ArticlesItem>(db) {
    override fun insertItem(data: ArticlesItem) {
        doAsync { database.articlesDao().insert(data) }
    }

    override fun insertAll(data: List<ArticlesItem>) {
        doAsync { database.articlesDao().insertAll(*data.toTypedArray()) }
    }

    override fun update(data: ArticlesItem) {
        doAsync { database.articlesDao().update(data) }
    }

    override fun delete(data: ArticlesItem) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteAll() {
        doAsync { database.articlesDao().deleteAll() }
    }

    override fun getItems(): LiveData<List<ArticlesItem>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun getItemsDataSource(): androidx.paging.DataSource.Factory<Int, ArticlesItem> {
        return database.articlesDao().getAllUsersDataSource()
    }

    override fun getItem(): LiveData<ArticlesItem> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}