package com.example.moviesapp.presentation.dependencyinjection

import com.example.moviesapp.domain.repository.MovieRepository
import com.example.moviesapp.domain.usecases.GetMoviesUseCase
import com.example.moviesapp.domain.usecases.UpdateMoviesUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMoviesUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepository)
    }
}