package com.abh.articles.data.dto.mapper

import com.abh.articles.commons.Utils
import com.abh.articles.data.dto.model.ArticleResponse
import com.abh.articles.domain.dto.model.Articles
import com.abh.articles.data.dto.model.Results


object ArticleResponseMapper {

    fun ArticleResponse.toNewsList(): List<Articles> {

        val artilesList = ArrayList<Articles>()
        val publishedFormat = "yyyy-MM-dd" //"2022-07-20"
        val updatedFormat = "yyyy-MM-dd HH:mm:ss" //2022-07-22 11:33:36

        results?.forEach { result ->

            try {

                val date = Utils.getTimestamp(
                    updatedFormat,
                    result.updated,
                    publishedFormat,
                    result.published_date
                )

                artilesList.add(
                    Articles(
                        result.id,
                        result.title,
                        result.abstract,
                        result.byline,
                        result.section,
                        date,
                        extractMediaUrl(result, true),
                        extractMediaUrl(result, false)
                    )
                )

                artilesList.sortByDescending { it.updated }
            } catch (e: Exception) {

                e.printStackTrace()
            }
        }

        return artilesList
    }

    private fun extractMediaUrl(result: Results, isThumb: Boolean) =
        if (result.media.isNotEmpty())
            if (result.media[if (isThumb) 0 else result.media.size - 1].`media-metadata`.isNotEmpty())
                result.media[if (isThumb) 0 else result.media.size - 1].`media-metadata`[if (isThumb) 0 else result.media[result.media.size - 1].`media-metadata`.size - 1].url
            else null
        else null
}