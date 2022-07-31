package com.abh.articles.presentation.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.abh.articles.databinding.ActivityDetailBinding
import com.abh.articles.domain.dto.model.Articles
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity  : AppCompatActivity() {

    lateinit var binding: ActivityDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)


        setContentView(binding.root)

        val article = intent.getSerializableExtra("articles")
        binding.articles = article as Articles?;


        setSupportActionBar(binding.actionBarLayout.actionBarToolBar)
        supportActionBar?.apply {

            setHomeButtonEnabled(true)
            setDisplayShowHomeEnabled(true)
            setDisplayUseLogoEnabled(true)
            setDisplayShowTitleEnabled(false)
        }



    }
    public fun onBackPress(v: View?) {
        onBackPressed()
    }





}