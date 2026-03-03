package com.jayden.locationmanager.app.viewmodel

import android.Manifest
import androidx.annotation.RequiresPermission
import androidx.lifecycle.ViewModel
import com.jayden.locationmanager.data.model.Coordinate
import com.jayden.locationmanager.data.repo.LocationRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val locationRepo: LocationRepo
) : ViewModel() {
    @RequiresPermission(anyOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    fun getLocation(
        provider: String,
        minTimeMs: Long = 1000L,
        minDistanceM: Float = 0.0f,
    ): SharedFlow<Coordinate> = locationRepo.getLocation(provider, minTimeMs, minDistanceM)

    @RequiresPermission(Manifest.permission.ACCESS_FINE_LOCATION)
    fun getNmeaLogs() = locationRepo.getNmeaLogs()
}