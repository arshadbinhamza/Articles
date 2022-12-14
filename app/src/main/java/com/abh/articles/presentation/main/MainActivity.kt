package com.abh.articles.presentation.main

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.abh.articles.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.viewModels
import com.abh.articles.R
import com.abh.articles.presentation.detail.DetailActivity

@AndroidEntryPoint
class MainActivity  : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.apply {
            viewModel = this@MainActivity.viewModel
            lifecycleOwner = this@MainActivity
        }
        setContentView(binding.root)



        setSupportActionBar(binding.actionBarLayout.actionBarToolBar)
        supportActionBar?.apply {

            setHomeButtonEnabled(true)
            setDisplayShowHomeEnabled(true)
            setDisplayUseLogoEnabled(true)
            setDisplayShowTitleEnabled(false)
        }

        binding.adapter = ArticleAdapter(listOf(), viewModel)

        viewModel.getInteractor().observe(this) {

            it.getContentIfNotHandled()?.let { transportData ->

                when (transportData) {

                    is MainViewModel.Interactor.UserClick -> {

//                        openNewsDetail(transportData.news)
                        val intent = Intent(this, DetailActivity::class.java).apply {
                            putExtra("articles", transportData.article)
                        }
                        startActivity(intent)
                    }
                    is MainViewModel.Interactor.Message -> {

                        Toast.makeText(this, transportData.message, Toast.LENGTH_SHORT).show()
                    }
                    is MainViewModel.Interactor.DataRefreshed -> {

                       binding.recyclerViewArticles.scrollToPosition(0)
                    }
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.menu_days, menu)

        when (viewModel.period) {

            1 -> {
                menu.findItem(R.id.period_one_day).isChecked = true
            }
            7 -> {
                menu.findItem(R.id.period_seven_days).isChecked = true
            }
            30 -> {
                menu.findItem(R.id.period_thirty_days).isChecked = true
            }
        }


        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {


            R.id.period_one_day -> {

                viewModel.updateOptionSeleted(1)
            }

            R.id.period_seven_days -> {

                viewModel.updateOptionSeleted(7)
            }

            R.id.period_thirty_days -> {

                viewModel.updateOptionSeleted(30)
            }
        }
        item.isChecked=true

        return super.onOptionsItemSelected(item)
    }



}