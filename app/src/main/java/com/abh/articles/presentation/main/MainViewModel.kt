package com.abh.articles.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abh.articles.domain.dto.model.Articles
import com.abh.articles.presentation.internal.Event
import com.abh.articles.commons.ExceptionParser
import com.abh.articles.domain.dto.model.ArticleRequest
import com.abh.articles.domain.usecase.GetArticles
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart

@HiltViewModel
class MainViewModel @Inject constructor( private val getArticles :GetArticles) : ViewModel(),ArticleListener {



    var period: Int=1
    var section: String = "all-sections"
    private val _articleList = MutableLiveData<List<Articles>>()
    val articleList: LiveData<List<Articles>> = _articleList

    private val _showProgressBar = MutableLiveData(false)
    val showProgressBar: LiveData<Boolean> = _showProgressBar

    private val _interactorBridge = MutableLiveData<Event<Interactor>>()
    private val interactorBridge: LiveData<Event<Interactor>> = _interactorBridge


    init {
        getArticles()
    }

    private fun getArticles() {
        viewModelScope.launch {


            try {

                getArticles.fetchArticles( ArticleRequest(section, period)).onStart {

                    _showProgressBar.postValue(true)
                }
                    .catch {

                        _showProgressBar.postValue(false)
                        showErrorResponse(ExceptionParser.getMessage(it as Exception))
                    }
                    .collect {

                        if (it is Boolean) {

                            _showProgressBar.postValue(it)
                        } else {

                            _showProgressBar.postValue(false)
                            _articleList.value = it as List<Articles>
                            _interactorBridge.value = Event(Interactor.DataRefreshed())
                        }
                    }
            } catch (error: Exception) {

                showErrorResponse(ExceptionParser.getMessage(error))
            }
        }
    }

    fun updateOptionSeleted(days: Int) {
        period = days;
        getArticles()

    }

    private fun showErrorResponse(message: Int) {

        _interactorBridge.value = Event(Interactor.Message(message))
    }


    override fun onArticleClicked(articles: Articles) {
        _interactorBridge.value = Event(Interactor.UserClick(articles))
    }



    fun getInteractor(): MutableLiveData<Event<Interactor>> {
        return _interactorBridge
    }


    sealed class Interactor {

        class Message(val message: Int) : Interactor()
        class UserClick(val article: Articles) : Interactor()
        class DataRefreshed() : Interactor()
    }
}