package com.tr.mvvmwithretrofit.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tr.mvvmwithretrofit.repository.QuoteRepository

class QuoteModelViewFactory(private val quoteRepository: QuoteRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuoteViewModel (quoteRepository)as T
    }
}