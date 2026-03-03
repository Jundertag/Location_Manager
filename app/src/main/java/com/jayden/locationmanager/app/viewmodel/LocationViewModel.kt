package com.jayden.locationmanager.app.viewmodel

import android.Manifest
import android.location.LocationManager
import androidx.annotation.RequiresPermission
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jayden.locationmanager.data.repository.LocationRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val repo: LocationRepo
) : ViewModel() {

    @RequiresPermission(anyOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    fun locationFlow(
        provider: String = LocationManager.GPS_PROVIDER,
        minTimeMs: Long = 1000L,
        minDistanceM: Float = 0.0f
    ) = repo.locationUpdatesFlow(
            provider,
            minTimeMs,
            minDistanceM
        ).stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            null
        )

    val allLocationProviders: List<String> = repo.getAllLocationProviders()

    @RequiresPermission(anyOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    fun onAnyLocationPermissionGranted() {
        repo.refreshLocationFlow()
    }

    fun restartLocationFlow() {
        repo.refreshLocationFlow()
    }

    companion object {
        private const val TAG = "LocationViewModel"
    }
}