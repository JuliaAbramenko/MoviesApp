package com.example.moviesapp.presentation.dependencyinjection

import com.example.moviesapp.data.datasource.MovieLocalDataSource
import com.example.moviesapp.data.datasourceimpl.MovieLocalDataSourceImpl
import com.example.moviesapp.data.db.MovieDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule() {
    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)

    }
}