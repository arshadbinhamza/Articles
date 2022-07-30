package com.abh.articles.app.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.abh.articles.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity  : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.actionBarLayout.actionBarToolBar)
        supportActionBar?.apply {

            setHomeButtonEnabled(true)
            setDisplayShowHomeEnabled(true)
            setDisplayUseLogoEnabled(true)
            setDisplayShowTitleEnabled(false)
        }
    }

}