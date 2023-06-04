package com.example.moviesapp.presentation.dependencyinjection

import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME) // annotate during runtime
annotation class MovieScope {
}