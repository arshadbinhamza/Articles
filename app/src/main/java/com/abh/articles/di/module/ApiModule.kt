package com.abh.articles.di.module

import com.abh.articles.data.networking.api.ArticleApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    fun provideArticleApi(retrofit: Retrofit): ArticleApi = retrofit.create(ArticleApi::class.java)

}