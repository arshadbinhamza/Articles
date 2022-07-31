package com.abh.articles.data.network.source

import com.abh.articles.domain.dto.model.ArticleRequest
import com.abh.articles.domain.dto.model.Articles


interface ArticleEntityData {

    suspend fun getArticles(articleRequest:  ArticleRequest): List<Articles>

}