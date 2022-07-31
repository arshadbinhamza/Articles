package com.abh.articles.data.networking.factory

import com.abh.articles.data.network.source.ArticleEntityData
import com.abh.articles.data.network.source.NetworkArticleEntityData
import javax.inject.Inject

class ArticleFactory @Inject constructor(
    private val networkArticleEntityData: NetworkArticleEntityData
) {

    fun get(): ArticleEntityData {

        return networkArticleEntityData
    }
}