package com.jayden.locationmanager.app.viewmodel

import android.Manifest
import android.location.LocationManager
import androidx.annotation.RequiresPermission
import androidx.lifecycle.ViewModel
import com.jayden.locationmanager.data.repository.LocationRepo
import com.jayden.locationmanager.model.location.Coordinate
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class LocationViewModel(
    private val repo: LocationRepo
) : ViewModel() {
    private var _location: MutableStateFlow<Coordinate?> = MutableStateFlow(null)
    val location = _location.asStateFlow()

    @RequiresPermission(anyOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    fun retrieveCachedLocation() {
        _location.value = repo.getCachedLocation()
    }

    /**
     * Retrieve live location.
     *
     * Requires any of [Manifest.permission.ACCESS_FINE_LOCATION], [Manifest.permission.ACCESS_COARSE_LOCATION] permissions
     *
     * @param sourceProvider The source provider
     * @param minimumTimeMs Minimum time before refreshing location. (0 to update as fast as possible)
     * @param minimumDistanceM Minimum distance before refreshing location. (0 to update without distance requirements)
     */
    @RequiresPermission(anyOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    fun retrieveLiveLocation(
        sourceProvider: String = LocationManager.GPS_PROVIDER,
        minimumTimeMs: Long = 1000L,
        minimumDistanceM: Float = 0.0f,
    ) {
        repo.requestLiveLocationUpdates(
            sourceProvider,
            minimumTimeMs,
            minimumDistanceM
        ) { location ->
            _location.value = location
        }
    }

    /**
     * Stop live location collection
     */
    fun stopLiveLocation() = repo.cancelLiveLocationUpdates()
}