package com.abh.articles.data.network.source

import com.abh.articles.data.dto.mapper.ArticleResponseMapper.toNewsList
import com.abh.articles.data.networking.api.ArticleApi
import com.abh.articles.domain.dto.model.ArticleRequest
import com.abh.articles.domain.dto.model.Articles
import javax.inject.Inject

class NetworkArticleEntityData @Inject constructor(private val articleApi: ArticleApi) : ArticleEntityData {



    override suspend fun getArticles(articleRequest: ArticleRequest): List<Articles> {
        return articleApi.getArticle(articleRequest.section, articleRequest.period).toNewsList()
    }


}