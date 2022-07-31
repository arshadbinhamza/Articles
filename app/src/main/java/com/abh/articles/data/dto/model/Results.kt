package com.abh.articles.data.dto.model


data class Results(
    val id: Long,
    val title: String,
    val published_date: String?,
    val updated: String?,
    val media: List<Media>,
    val byline: String,
    val `abstract`: String,
    val adx_keywords: String,
    val asset_id: Long,
    val section: String,
    val source: String,
    val subsection: String,
)