package com.abh.articles.data.dto.model

data class Media(
    val caption: String,
    val `media-metadata`: List<MediaMetadata>,
    val subtype: String,
    val type: String
)