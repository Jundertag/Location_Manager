package com.jayden.locationmanager.data.repository

import android.Manifest
import android.location.Location
import android.location.LocationManager
import androidx.annotation.RequiresPermission
import com.jayden.locationmanager.model.location.Coordinate
import com.jayden.locationmanager.data.source.AppLocationManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocationRepo(
    private val source: AppLocationManager
) {
    @RequiresPermission(anyOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    fun getCachedLocation(): Coordinate? = source.getCachedLocation()?.toCoordinate()

    @RequiresPermission(anyOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    fun requestSingleLocationUpdate(
        provider: String = LocationManager.GPS_PROVIDER,
        onLocationUpdate: ((Coordinate) -> Unit)
    ) {
        source.requestSingleLocationUpdate(provider) { location ->
            onLocationUpdate(location.toCoordinate())
        }
    }

    @RequiresPermission(anyOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    fun requestLiveLocationUpdates(
        provider: String = LocationManager.GPS_PROVIDER,
        minTimeMs: Long = 1000L,
        minDistanceM: Float = 0.0f,
        onLocationUpdate: (Coordinate) -> Unit
    ) {
        source.requestLiveLocationUpdates(
            provider,
            minTimeMs,
            minDistanceM,
        ) { location ->
            onLocationUpdate(location.toCoordinate())
        }
    }

    fun getAllLocationProviders(): List<String> = source.getAllProviders()

    @RequiresPermission(anyOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    fun locationUpdatesFlow(
        provider: String = LocationManager.GPS_PROVIDER,
        minTimeMs: Long = 1000L,
        minDistanceM: Float = 0.0f
    ): Flow<Coordinate?> = source.locationUpdatesFlow(provider, minTimeMs, minDistanceM).map { it?.toCoordinate() }

    fun refreshLocationFlow() {
        source.notifyOnProviderChangeRequest()
    }
}

fun Location.toCoordinate(): Coordinate = Coordinate(latitude = this.latitude, longitude = this.longitude, bearing = this.bearing, provider = this.provider)