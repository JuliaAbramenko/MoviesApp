package com.example.moviesapp.domain.usecases

import com.example.moviesapp.data.model.Movie
import com.example.moviesapp.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.getMovies()
}