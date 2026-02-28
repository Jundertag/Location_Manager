package com.jayden.locationmanager.data.source

import android.Manifest
import android.content.Context
import android.location.LocationManager
import androidx.annotation.RequiresPermission

class AppNmeaLogsListener(
    private val context: Context,
    private val locationManager: LocationManager,
) {
    @RequiresPermission(Manifest.permission.ACCESS_FINE_LOCATION)
    fun listenForNmeaMessages(
        onMessage: (String) -> Unit
    ) {
        locationManager.addNmeaListener(
            { message, _ -> onMessage(message) },
            null
        )
    }
}