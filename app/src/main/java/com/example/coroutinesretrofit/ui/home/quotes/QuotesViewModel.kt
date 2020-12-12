package com.example.coroutinesretrofit.ui.home.quotes

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coroutinesretrofit.model.Movie
import com.example.coroutinesretrofit.model.Quote
import com.example.coroutinesretrofit.network.MyApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class QuotesViewModel : ViewModel() {

    private val TAG = "QuoteViewModel"

    val quotes: LiveData<List<Quote>> = MutableLiveData()

    init {
        viewModelScope.launch {
            quotes as MutableLiveData
            var tempList: ArrayList<Quote> = ArrayList()

            for (i in 1..5) {
                val quotes1 = async { getQuotes() }
                val quotes2 = async { getQuotes() }
                val quotes3 = async { getQuotes() }

                tempList.addAll(quotes1.await()!!)
                tempList.addAll(quotes2.await()!!)
                tempList.addAll(quotes3.await()!!)

                quotes.value = tempList
            }

        }
    }


    private suspend fun getQuotes(): List<Quote>? {
        return withContext(Dispatchers.IO) {
            android.util.Log.i(TAG, "Getting Quotes")
            MyApi().getQuotes().body()?.quotes
        }
    }

    private suspend fun getMovies(): List<Movie>? {
        return withContext(Dispatchers.IO) {
            android.util.Log.e(TAG, "Getting Movies")
            MyApi().getMovies().body()
        }
    }
}