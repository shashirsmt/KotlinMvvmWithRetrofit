package com.tr.mvvmwithretrofit.api

import com.tr.mvvmwithretrofit.models.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteApiService {
    @GET("/quotes")
    suspend fun getQuotes(@Query("page")page : Int) : Response<QuoteList>

    suspend fun getNamed(@Query("page") page : Int ) : Response<QuoteList>


}