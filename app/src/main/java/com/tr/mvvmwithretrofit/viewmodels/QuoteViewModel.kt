package com.tr.mvvmwithretrofit.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tr.mvvmwithretrofit.models.QuoteList
import com.tr.mvvmwithretrofit.repository.QuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuoteViewModel(private  val quoteRepository: QuoteRepository) : ViewModel(){

    init {
        viewModelScope.launch (Dispatchers.IO){
            quoteRepository.getQuotes(1)
        }
    }

    val quotes : LiveData<QuoteList>
    get() = quoteRepository.quotes
}