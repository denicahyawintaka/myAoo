package com.example.myapplication.model.response

import com.example.myapplication.model.entity.Movie

data class PopularResponse(
    val total_results: Int,
    val results: List<Movie>
)