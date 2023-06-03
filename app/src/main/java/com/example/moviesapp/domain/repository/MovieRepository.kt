package com.example.moviesapp.domain.repository

import com.example.moviesapp.data.model.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}