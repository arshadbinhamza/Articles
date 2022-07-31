package com.abh.articles.data.networking.api


import com.abh.articles.BuildConfig
import com.abh.articles.data.dto.model.ArticleResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ArticleApi {

    //@Headers("mock:true")
    @GET("/svc/mostpopular/v2/mostviewed/{section}/{period}.json")
    suspend fun getArticle(
        @Path("section") section: String,
        @Path("period") period: Int,
        @Query("api-key") key: String? = BuildConfig.API_KEY
    ): ArticleResponse
}