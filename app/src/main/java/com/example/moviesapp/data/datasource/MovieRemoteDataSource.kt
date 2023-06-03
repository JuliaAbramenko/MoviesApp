package com.example.moviesapp.data.datasource

import com.example.moviesapp.data.model.Movie
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<List<Movie>>
}