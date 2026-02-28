package com.jayden.locationmanager.app.viewmodel

import android.Manifest
import androidx.annotation.RequiresPermission
import androidx.lifecycle.ViewModel
import com.jayden.locationmanager.model.location.Coordinate
import com.jayden.locationmanager.data.repository.LocationRepo
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

    @RequiresPermission(anyOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    fun updateLocation() {
        repo.requestSingleLocationUpdate { newLocation ->
            _location.value = newLocation
        }
    }
}