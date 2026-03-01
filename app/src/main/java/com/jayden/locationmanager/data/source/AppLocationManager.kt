package com.jayden.locationmanager.data.source

import android.Manifest
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.annotation.RequiresPermission
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.onStart

class AppLocationManager(
    private val locationManager: LocationManager
) {
    val gpsProvider = LocationManager.GPS_PROVIDER

    private var locationListener: LocationListener? = null

    private val refreshRequests = MutableSharedFlow<Unit>(
        replay = 0,
        extraBufferCapacity = 1
    )

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

    fun getAllProviders(): List<String> = locationManager.allProviders

    fun notifyOnProviderChangeRequest() {
        refreshRequests.tryEmit(Unit)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @RequiresPermission(anyOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    fun locationUpdatesFlow(
        provider: String,
        minTimeMs: Long,
        minDistanceM: Float,
    ): Flow<Location> {
        return refreshRequests.onStart {
            emit(Unit)
        }.flatMapLatest {
            callbackFlow {
                locationManager.getLastKnownLocation(provider)?.let {
                    trySend(it)
                }
                locationListener = LocationListener { location -> trySend(location) }
                locationManager.requestLocationUpdates(
                    provider,
                    minTimeMs,
                    minDistanceM,
                    locationListener!!
                )
                awaitClose {
                    locationListener?.let {
                        locationManager.removeUpdates(it)
                    }
                    locationListener = null
                }
            }
        }
    }
}