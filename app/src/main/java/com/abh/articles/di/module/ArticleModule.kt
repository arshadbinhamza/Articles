package com.abh.articles.di.module

import com.abh.articles.data.networking.repository.ArticleRepositoryImpl
import com.abh.articles.domain.dto.repository.ArticlesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ArticleModule {

    @Binds
    abstract fun bindArticlesRepository(articleRepositoryImpl: ArticleRepositoryImpl): ArticlesRepository
}