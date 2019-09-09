package com.github.mohamedwael.latestnews.applevel.storage.dao

import androidx.paging.DataSource
import androidx.room.*
import com.github.mohamedwael.latestnews.modules.response.ArticlesItem


@Dao
interface ArticlesDao {

    @Query("SELECT * from articles")
    fun getAllUsersDataSource(): DataSource.Factory<Int, ArticlesItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg repos: ArticlesItem)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(repo: ArticlesItem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(repo: ArticlesItem)

    @Query("DELETE FROM articles")
    fun deleteAll()
}