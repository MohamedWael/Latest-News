package com.github.mohamedwael.latestnews.applevel.storage

import android.content.Context
import com.github.mohamedwael.latestnews.applevel.storage.datasource.ArticlesDataSource

object StorageManager {

    lateinit var articlesDataSource: ArticlesDataSource

    fun init(context: Context) {
        val db = AppDatabase.getDatabase(context)
        articlesDataSource = ArticlesDataSource(db)
    }
}