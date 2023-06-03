package com.example.moviesapp.data

import com.example.moviesapp.data.datasource.MovieCacheDataSource
import com.example.moviesapp.data.datasource.MovieLocalDataSource
import com.example.moviesapp.data.datasource.MovieRemoteDataSource
import com.example.moviesapp.data.model.Movie
import com.example.moviesapp.domain.repository.MovieRepository
import retrofit2.Retrofit
import java.lang.Exception

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromApi()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromApi(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if(body!=null) {
                movieList = body.movies
            }
        } catch (exception: Exception) {

        }
        return movieList

    }

    private suspend fun getMoviesFromROOM(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
        } catch (exception: Exception) {

        }
        if(movieList.isNotEmpty()) {
           return movieList
        }
        else {
            movieList = getMoviesFromApi()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    private suspend fun getMoviesFromCache(): List<Movie>? {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        } catch (exception: Exception) {

        }
        if(movieList.isNotEmpty()) {
            return movieList
        }
        else {
            movieList = getMoviesFromROOM()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }
}