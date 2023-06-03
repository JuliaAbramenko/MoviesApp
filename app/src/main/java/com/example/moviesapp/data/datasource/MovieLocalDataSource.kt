package com.example.moviesapp.data.datasource

import com.example.moviesapp.data.model.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB(): List<Movie>

    suspend fun saveMoviesToDB(movies: List<Movie>)

    suspend fun clearAll()
}