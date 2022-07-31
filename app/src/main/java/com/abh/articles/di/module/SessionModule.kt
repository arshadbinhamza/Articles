package com.abh.articles.di.module

import android.content.Context
import com.abh.articles.data.session.SessionContext
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object SessionModule {

    @Provides
    fun providerSessionContext(@ApplicationContext context: Context) = SessionContext(context)
}