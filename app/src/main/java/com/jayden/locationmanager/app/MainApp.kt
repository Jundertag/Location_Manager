package com.jayden.locationmanager.app

import android.app.Application
import com.jayden.locationmanager.app.viewmodel.LocationViewModelFactory
import com.jayden.locationmanager.app.viewmodel.MainViewModelFactory
import com.jayden.locationmanager.data.repository.LocationRepo
import com.jayden.locationmanager.data.source.AppLocationManager

class MainApp : Application() {
    lateinit var locationManager: AppLocationManager
        private set
    lateinit var locationRepo: LocationRepo
        private set
    lateinit var mainViewModelFactory: MainViewModelFactory
        private set
    lateinit var locationViewModelFactory: LocationViewModelFactory
        private set

    override fun onCreate() {
        super.onCreate()

        locationManager = AppLocationManager(applicationContext)
        locationRepo = LocationRepo(locationManager)
        mainViewModelFactory = MainViewModelFactory(locationRepo)
        locationViewModelFactory = LocationViewModelFactory(locationRepo)
    }
}