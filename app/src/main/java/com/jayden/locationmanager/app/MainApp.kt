package com.jayden.locationmanager.app

import android.app.Application
import androidx.room.Room
import com.jayden.locationmanager.app.viewmodel.LocationViewModelFactory
import com.jayden.locationmanager.app.viewmodel.MainViewModelFactory
import com.jayden.locationmanager.app.viewmodel.NmeaLogsViewModelFactory
import com.jayden.locationmanager.data.repository.LocationRepo
import com.jayden.locationmanager.data.repository.NmeaLogsRepo
import com.jayden.locationmanager.data.source.AppLocationManager
import com.jayden.locationmanager.data.source.NmeaLogsDatabase

class MainApp : Application() {
    lateinit var locationManager: AppLocationManager
        private set
    lateinit var locationRepo: LocationRepo
        private set
    lateinit var mainViewModelFactory: MainViewModelFactory
        private set
    lateinit var locationViewModelFactory: LocationViewModelFactory
        private set
    lateinit var nmeaLogsRepo: NmeaLogsRepo
        private set
    lateinit var nmeaLogsViewModelFactory: NmeaLogsViewModelFactory
        private set

    val nmeaLogsDatabase by lazy {
        Room.databaseBuilder(
            applicationContext,
            NmeaLogsDatabase::class.java, "nmea_logs_db"
        ).build()
    }

    override fun onCreate() {
        super.onCreate()

        locationManager = AppLocationManager(applicationContext)
        locationRepo = LocationRepo(locationManager)
        mainViewModelFactory = MainViewModelFactory(locationRepo)
        locationViewModelFactory = LocationViewModelFactory(locationRepo)
        nmeaLogsRepo = NmeaLogsRepo(nmeaLogsDatabase.nmeaEventDao())
        nmeaLogsViewModelFactory = NmeaLogsViewModelFactory(nmeaLogsRepo)
    }
}