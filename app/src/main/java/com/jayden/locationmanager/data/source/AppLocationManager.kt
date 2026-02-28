package com.jayden.locationmanager.data.source

import android.Manifest
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.location.LocationRequest
import android.os.Build
import androidx.annotation.RequiresPermission

class AppLocationManager(
    private val context: Context
) {
    val locationManager: LocationManager = context.getSystemService(LocationManager::class.java)
    val gpsProvider = LocationManager.GPS_PROVIDER

    @RequiresPermission(anyOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    fun getCachedLocation(): Location? {

        return if (locationManager.isLocationEnabled) {
            locationManager.getLastKnownLocation(gpsProvider)
        } else {
            null
        }
    }

    @RequiresPermission(anyOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    fun requestSingleLocationUpdate(
        provider: String,
        newLocation: ((Location) -> Unit)
    ) {
        locationManager.requestLocationUpdates(
            provider,
            1000L,
            0.0f,
            object : LocationListener {
                override fun onLocationChanged(location: Location) {
                    locationManager.removeUpdates(this)
                    newLocation(location)
                }
            }
        )
    }
}