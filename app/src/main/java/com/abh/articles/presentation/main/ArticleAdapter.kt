package com.abh.articles.presentation.main

import com.abh.articles.R
import com.abh.articles.presentation.base.BaseAdapter
import com.abh.articles.domain.dto.model.Articles
import com.abh.articles.databinding.ItemArticlesBinding

class ArticleAdapter(
    private val list: List<Articles>,
    private val articleListener: ArticleListener
) : BaseAdapter<ItemArticlesBinding, Articles>(list) {

    override val layoutId: Int = R.layout.item_articles

    override fun bind(binding: ItemArticlesBinding, item: Articles) {
        binding.apply {
            articles = item
            listener = articleListener
            executePendingBindings()
        }
    }
}

interface ArticleListener {
    fun onArticleClicked(articles: Articles)
}