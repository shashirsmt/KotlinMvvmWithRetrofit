package com.tr.mvvmwithretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.tr.mvvmwithretrofit.api.QuoteApiService
import com.tr.mvvmwithretrofit.api.RetroInstance
import com.tr.mvvmwithretrofit.repository.QuoteRepository
import com.tr.mvvmwithretrofit.viewmodels.QuoteModelViewFactory
import com.tr.mvvmwithretrofit.viewmodels.QuoteViewModel

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: QuoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // initViewmodel()
       //val btnTest=findViewById<Button>(R.id.btnTest)
       val quoteApiService = RetroInstance.getRetroInstance().create(QuoteApiService::class.java)
        val quoteRepositoryn= QuoteRepository(quoteApiService)
        mainViewModel = ViewModelProvider(this,QuoteModelViewFactory(quoteRepositoryn)).get(QuoteViewModel::class.java)
       mainViewModel.quotes.observe(this, Observer {
           Log.d("MVVM",it.results.toString())
       })



    }

//    private fun initViewmodel() {
//        mainViewModel=ViewModelProvider(this).get(MainViewModel::class.java)
//
//        mainViewModel.getLiveDataObserver().observe(this, Observer {
//
//            Log.d("mainActiivty", it[0].rocket.toString());
//        })
//
//        mainViewModel.makeApicall()
//    }
}