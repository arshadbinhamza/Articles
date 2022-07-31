package com.abh.articles.domain.usecase

import com.abh.articles.data.network.CoroutineDispatcherProvider
import com.abh.articles.domain.dto.model.ArticleRequest
import com.abh.articles.domain.dto.repository.ArticlesRepository
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetArticles  @Inject constructor(
    private val articleRepository: ArticlesRepository,
    private val coroutineDispatcherProvider: CoroutineDispatcherProvider
)  {

    fun fetchArticles(articleRequest: ArticleRequest) = flow {

        emit(true) //to show the fetch progress
        val articles = articleRepository.getArticlesFromNetwork(articleRequest)


        if (articles.isNotEmpty()) { //Else it will be network or data error, which will be caught in the VM
            emit(articles)
        }
    }
        .flowOn(coroutineDispatcherProvider.IO())
}