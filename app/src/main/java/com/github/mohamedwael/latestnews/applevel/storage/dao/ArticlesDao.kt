package com.github.mohamedwael.latestnews.applevel.storage.dao

import androidx.paging.DataSource
import androidx.room.*
import com.github.mohamedwael.latestnews.modules.news.response.ArticleItem


@Dao
interface ArticlesDao {

    @Query("SELECT * from articles")
    fun getAllUsersDataSource(): DataSource.Factory<Int, ArticleItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg repos: ArticleItem)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(repo: ArticleItem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(repo: ArticleItem)

    @Query("DELETE FROM articles")
    fun deleteAll()
}