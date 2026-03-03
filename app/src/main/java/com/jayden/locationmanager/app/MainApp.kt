package com.jayden.locationmanager.app

import android.app.Application
import android.location.LocationManager
import androidx.room.Room
import com.jayden.locationmanager.data.repository.LocationRepo
import com.jayden.locationmanager.data.repository.NmeaLogsRepo
import com.jayden.locationmanager.data.source.AppLocationManager
import com.jayden.locationmanager.data.source.AppNmeaLogsListener
import com.jayden.locationmanager.data.source.room.NmeaLogsDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}