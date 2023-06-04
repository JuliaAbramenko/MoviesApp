package com.example.moviesapp.presentation.dependencyinjection

import com.example.moviesapp.data.datasource.MovieCacheDataSource
import com.example.moviesapp.data.datasourceimpl.MovieCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }
}