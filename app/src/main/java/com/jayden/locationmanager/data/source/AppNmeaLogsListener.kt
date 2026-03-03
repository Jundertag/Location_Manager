package com.jayden.locationmanager.data.source

import android.Manifest
import android.content.Context
import android.location.LocationManager
import android.location.OnNmeaMessageListener
import androidx.annotation.RequiresPermission
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AppNmeaLogsListener @Inject constructor(
    @param:ApplicationContext private val context: Context,
    private val locationManager: LocationManager,
) {
    private var nmeaMessageListener: OnNmeaMessageListener? = null
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