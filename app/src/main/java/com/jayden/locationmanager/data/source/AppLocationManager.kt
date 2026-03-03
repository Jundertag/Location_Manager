package com.jayden.locationmanager.data.source

import android.Manifest
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.annotation.RequiresPermission
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class AppLocationManager @Inject constructor(
    @param:ApplicationContext private val context: Context,
) {
    private val locationManager: LocationManager by lazy {
        context.getSystemService(LocationManager::class.java)
    }

    private var callback: LocationListener? = null

    @RequiresPermission(anyOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    fun locationUpdatesFlow(
        provider: String,
        minTimeMs: Long,
        minDistanceM: Float,
    ): Flow<Location> = callbackFlow {
        if (callback == null) {
            callback = LocationListener { location -> trySend(location) }
        }
        locationManager.requestLocationUpdates(
            provider, minTimeMs, minDistanceM, callback!!
        )

        awaitClose {
            locationManager.removeUpdates(callback!!)
            callback = null
        }
    }
}