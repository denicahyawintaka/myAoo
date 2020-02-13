package com.example.myapplication.network

import com.example.myapplication.model.response.PopularResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRequest {
    @GET("3/movie/popular?")
    fun getPopular(@Query("api_key") api_key: String): Observable<PopularResponse>
}