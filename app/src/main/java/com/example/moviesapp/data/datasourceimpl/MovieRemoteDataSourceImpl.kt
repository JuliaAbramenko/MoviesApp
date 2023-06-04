package com.example.moviesapp.data.datasourceimpl

import com.example.moviesapp.data.api.TMDBService
import com.example.moviesapp.data.datasource.MovieRemoteDataSource
import com.example.moviesapp.data.model.MovieList
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : MovieRemoteDataSource {

    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)

}