package com.abh.articles.domain.dto.model

import com.abh.articles.presentation.base.BaseListItem
import java.io.Serializable

data class Articles (
    val id: Long,
    val title: String,
    val summary: String,
    val byline: String,
    val section: String,
    val updated: Long,
    val thumb: String?,
    val banner: String?
) : BaseListItem, Serializable
