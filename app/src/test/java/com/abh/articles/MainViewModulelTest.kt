package com.abh.articles

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.abh.articles.data.network.CoroutineDispatcherProvider
import com.abh.articles.data.networking.repository.ArticleRepositoryImpl
import com.abh.articles.domain.usecase.GetArticles
import com.abh.articles.presentation.main.MainViewModel
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock

import java.util.concurrent.TimeUnit

class MainViewModulelTest {
    @get:Rule
    val mainCoroutineRule = CoroutineRuleConfig()


    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var getArticles: GetArticles
    private lateinit var viewModel: MainViewModel

    private var articleRepositoryImpl = mock<ArticleRepositoryImpl>()

    @Before
    fun setup() {

        getArticles = GetArticles(articleRepositoryImpl, CoroutineDispatcherProvider())
    }

    @Test
    fun checkViewMOdelInit() = runBlocking {



        viewModel = MainViewModel(getArticles)

        TimeUnit.MINUTES.sleep(1)

//        Assert.assertEquals(false, viewModel.articleList.value.isNullOrEmpty())


        Assert.assertEquals(false, viewModel.showProgressBar.value)
    }
}