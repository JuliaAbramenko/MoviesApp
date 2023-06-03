package com.example.moviesapp.data.datasource

import com.example.moviesapp.data.model.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache(): List<Movie>

    suspend fun saveMoviesToCache(movies: List<Movie>)

}