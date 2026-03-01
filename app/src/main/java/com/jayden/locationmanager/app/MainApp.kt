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

class MainApp : Application() {
    lateinit var appLocationManager: AppLocationManager
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
    lateinit var nmeaLogsListener: AppNmeaLogsListener
        private set

    val nmeaLogsDatabase by lazy {
        Room.databaseBuilder(
            applicationContext,
            NmeaLogsDatabase::class.java, "nmea_logs_db"
        ).build()
    }

    override fun onCreate() {
        super.onCreate()
        val locationManager = applicationContext.getSystemService(LocationManager::class.java)

        appLocationManager = AppLocationManager(locationManager)
        locationRepo = LocationRepo(appLocationManager, applicationContext)
        mainViewModelFactory = MainViewModelFactory(locationRepo)
        locationViewModelFactory = LocationViewModelFactory(locationRepo)
        nmeaLogsListener = AppNmeaLogsListener(applicationContext, locationManager)
        nmeaLogsRepo = NmeaLogsRepo(nmeaLogsDatabase.nmeaEventDao(), nmeaLogsListener)
        nmeaLogsViewModelFactory = NmeaLogsViewModelFactory(nmeaLogsRepo)
    }
}