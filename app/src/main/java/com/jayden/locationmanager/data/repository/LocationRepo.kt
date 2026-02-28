package com.jayden.locationmanager.data.repository

import android.Manifest
import android.location.LocationManager
import androidx.annotation.RequiresPermission
import com.jayden.locationmanager.model.location.Coordinate
import com.jayden.locationmanager.data.source.AppLocationManager

class LocationRepo(
    private val source: AppLocationManager
) {
    @RequiresPermission(anyOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    fun getCachedLocation(): Coordinate? {
        val rawLocation = source.getCachedLocation() ?: return null

        return Coordinate(
            latitude = rawLocation.latitude,
            longitude = rawLocation.longitude,
            bearing = if (rawLocation.hasBearing()) rawLocation.bearing else null
        )
    }

    @RequiresPermission(anyOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    fun requestSingleLocationUpdate(
        provider: String = LocationManager.GPS_PROVIDER,
        onLocationUpdate: ((Coordinate) -> Unit)
    ) {
        val rawLocation = source.requestSingleLocationUpdate(provider) { location ->
            onLocationUpdate(Coordinate(
                location.latitude,
                location.longitude,
                location.bearing
            ))
        }
    }
}