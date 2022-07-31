package com.abh.articles.data.networking.repository

import com.abh.articles.data.networking.factory.ArticleFactory
import com.abh.articles.domain.dto.model.ArticleRequest
import com.abh.articles.domain.dto.model.Articles
import com.abh.articles.domain.dto.repository.ArticlesRepository

import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(private val articleFactory: ArticleFactory) :
    ArticlesRepository {

    override suspend fun getArticlesFromNetwork(articleRequest: ArticleRequest): List<Articles> {
        return articleFactory.get().getArticles(articleRequest)
    }


}