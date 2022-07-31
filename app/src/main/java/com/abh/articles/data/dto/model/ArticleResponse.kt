package com.abh.articles.data.dto.model

import com.abh.articles.data.dto.model.Results

data class ArticleResponse(
    val status: String,
    val num_results: Int,
    val results: List<Results>?
)