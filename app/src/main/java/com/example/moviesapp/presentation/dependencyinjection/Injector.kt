package com.example.moviesapp.presentation.dependencyinjection

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
}