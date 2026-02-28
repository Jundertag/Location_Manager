package com.jayden.locationmanager.data.source

import android.Manifest
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.annotation.RequiresPermission

class AppLocationManager(
    private val locationManager: LocationManager
) {
    val gpsProvider = LocationManager.GPS_PROVIDER

    private var locationListener: LocationListener? = null

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

    @RequiresPermission(anyOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    fun requestLiveLocationUpdates(
        provider: String,
        minTimeMs: Long,
        minDistanceM: Float,
        onNewLocation: ((Location) -> Unit)
    ) {
        locationListener = LocationListener { location -> onNewLocation(location) }
        locationManager.requestLocationUpdates(
            provider,
            minTimeMs,
            minDistanceM,
            locationListener!!
        )
    }

    fun cancelLiveLocationUpdates() {
        locationListener?.let {
            locationManager.removeUpdates(it)
        }
        locationListener = null
    }
}