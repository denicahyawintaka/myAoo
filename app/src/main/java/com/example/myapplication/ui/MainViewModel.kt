package com.example.myapplication.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.entity.Movie
import com.example.myapplication.network.RetrofitClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainViewModel: ViewModel() {
    private lateinit var subscription: Disposable
    val data = MutableLiveData<List<Movie>>()

    fun getData(){
        subscription = RetrofitClient.apiRequest.getPopular(RetrofitClient.API_KEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                data.value = it.results
            },{
                Log.d("API EROR", it.message)
            })

    }

}