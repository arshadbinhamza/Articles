package com.abh.articles

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ArticleApp : Application() {

    override fun onCreate() {

        super.onCreate()

    }
}