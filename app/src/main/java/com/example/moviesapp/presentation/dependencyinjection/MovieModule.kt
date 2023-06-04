package com.example.moviesapp.presentation.dependencyinjection

import com.example.moviesapp.domain.usecases.GetMoviesUseCase
import com.example.moviesapp.domain.usecases.UpdateMoviesUseCase
import com.example.moviesapp.presentation.MyViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactor(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ) : MyViewModelFactory {
        return MyViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }
}