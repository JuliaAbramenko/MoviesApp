package com.example.moviesapp

import android.app.Application
import com.example.moviesapp.presentation.dependencyinjection.AppComponent
import com.example.moviesapp.presentation.dependencyinjection.AppModule
import com.example.moviesapp.presentation.dependencyinjection.DaggerAppComponent
import com.example.moviesapp.presentation.dependencyinjection.Injector
import com.example.moviesapp.presentation.dependencyinjection.MovieSubComponent
import com.example.moviesapp.presentation.dependencyinjection.NetModule
import com.example.moviesapp.presentation.dependencyinjection.RemoteDataModule

class App : Application(),Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        // preparation of dagger before direct launch
        appComponent =  DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

}