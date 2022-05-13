package com.tr.mvvmwithretrofit.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tr.mvvmwithretrofit.api.QuoteApiService
import com.tr.mvvmwithretrofit.models.QuoteList

class QuoteRepository(private val quoteApiService: QuoteApiService) {

    private val quotesLiveData = MutableLiveData<QuoteList>()

    val quotes : LiveData<QuoteList>
    get() = quotesLiveData

    suspend fun getQuotes(page : Int){

        val result = quoteApiService.getQuotes(page)
        if(result?.body()!=null){
           quotesLiveData.postValue(result.body())
        }
    }
}