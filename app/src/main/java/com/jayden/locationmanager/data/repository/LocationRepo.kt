package com.jayden.locationmanager.data.repository

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import androidx.annotation.RequiresPermission
import androidx.core.content.ContextCompat
import com.jayden.locationmanager.model.location.Coordinate
import com.jayden.locationmanager.data.source.AppLocationManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.map

class LocationRepo(
    private val source: AppLocationManager,
    private val context: Context
) {
    @RequiresPermission(anyOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    fun getCachedLocation(): Coordinate? = source.getCachedLocation()?.toCoordinate()

    fun getAllLocationProviders(): List<String> = source.getAllProviders()

    @RequiresPermission(anyOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    fun locationUpdatesFlow(
        provider: String = LocationManager.GPS_PROVIDER,
        minTimeMs: Long = 1000L,
        minDistanceM: Float = 0.0f
    ): Flow<Coordinate> {
        if (ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED) {
            return emptyFlow()
        }

        return source.locationUpdatesFlow(provider, minTimeMs, minDistanceM).map { it.toCoordinate() }
    }

    fun refreshLocationFlow() {
        source.notifyOnProviderChangeRequest()
    }
}

fun Location.toCoordinate(): Coordinate = Coordinate(latitude = this.latitude, longitude = this.longitude, bearing = this.bearing, provider = this.provider)