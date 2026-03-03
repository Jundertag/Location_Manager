package com.jayden.locationmanager.app

import android.app.Application
import android.location.LocationManager
import androidx.room.Room
import com.jayden.locationmanager.app.viewmodel.LocationViewModelFactory
import com.jayden.locationmanager.app.viewmodel.MainViewModelFactory
import com.jayden.locationmanager.app.viewmodel.NmeaLogsViewModelFactory
import com.jayden.locationmanager.data.repository.LocationRepo
import com.jayden.locationmanager.data.repository.NmeaLogsRepo
import com.jayden.locationmanager.data.source.AppLocationManager
import com.jayden.locationmanager.data.source.AppNmeaLogsListener
import com.jayden.locationmanager.data.source.room.NmeaLogsDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApp : Application() {
    lateinit var mainViewModelFactory: MainViewModelFactory
        private set
    lateinit var locationViewModelFactory: LocationViewModelFactory
        private set
    lateinit var nmeaLogsViewModelFactory: NmeaLogsViewModelFactory
        private set


    override fun onCreate() {
        super.onCreate()
    }
}