package com.abh.articles.domain.dto.repository

import com.abh.articles.domain.dto.model.ArticleRequest
import com.abh.articles.domain.dto.model.Articles


interface ArticlesRepository {

    suspend fun getArticlesFromNetwork(articleRequest: ArticleRequest): List<Articles>


}