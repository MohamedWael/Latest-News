package com.github.mohamedwael.latestnews.modules.news.viewmodel

import com.github.mohamedwael.latestnews.applevel.BASE_API
import com.github.mohamedwael.latestnews.applevel.network.ApiKetInterceptor
import com.github.mohamedwael.latestnews.applevel.network.Retrofit
import com.github.mohamedwael.latestnews.applevel.storage.AppDatabase
import com.github.mohamedwael.latestnews.applevel.storage.StorageManager
import com.github.mohamedwael.latestnews.applevel.storage.dao.ArticlesDao
import com.github.mohamedwael.latestnews.applevel.storage.datasource.ArticlesDataSource
import com.github.mohamedwael.latestnews.modules.news.repo.NewsRepo
import okhttp3.OkHttpClient
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class NewsViewModelTest {

    lateinit var viewModel: NewsViewModel
    lateinit var repo: NewsRepo
    @Before
    fun setUp() {
        repo = Mockito.mock(NewsRepo::class.java)
        Retrofit.init(
            httpClient = OkHttpClient.Builder().addInterceptor(ApiKetInterceptor("apikey")),
            baseUrl = BASE_API
        )
        val db = Mockito.mock(AppDatabase::class.java)
        Mockito.`when`(db.articlesDao()).thenReturn(Mockito.mock(ArticlesDao::class.java))
        Mockito.`when`(db.articlesDao().getAllUsersDataSource()).thenReturn(FakeReposDataSource())
        StorageManager.articlesDataSource= ArticlesDataSource(db)
        Mockito.`when`(repo.getNewsDataSource()).thenReturn(FakeReposDataSource())
        viewModel = NewsViewModel(repo)
    }

    @Test
    fun testIsShowingProgress() {
        viewModel.getNews()
        Assert.assertTrue(viewModel.showProgress.get() == true)
    }

    @Test
    fun testHideProgress() {
        viewModel.hideProgress()
        Assert.assertFalse(viewModel.showProgress.get() ?: true)
    }

    @Test
    fun testGetUserData() {
        viewModel.getNews()
        Assert.assertTrue(viewModel.showProgress.get() ?: false)
        Mockito.verify(repo, Mockito.times(1)).getNews()
    }
}