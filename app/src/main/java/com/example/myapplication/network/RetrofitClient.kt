package com.example.myapplication.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val URL: String = "https://api.themoviedb.org/"
    const val API_KEY: String = "eb7fda7d2094a7d74a933e33ed24e7d4"

    val retrofit: Retrofit =
        Retrofit.Builder()
            .baseUrl(URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    val apiRequest: ApiRequest = retrofit.create(ApiRequest::class.java)

}