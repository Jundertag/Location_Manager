package com.jayden.locationmanager.data.source

import android.Manifest
import android.content.Context
import android.location.LocationManager
import android.location.OnNmeaMessageListener
import androidx.annotation.RequiresPermission
import com.jayden.locationmanager.data.model.NmeaMessage
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class AppNmeaLogsManager @Inject constructor(
    @param:ApplicationContext private val context: Context
) {
    private val locationManager by lazy {
        context.getSystemService(LocationManager::class.java)
    }

    private var callback: OnNmeaMessageListener? = null

    @RequiresPermission(Manifest.permission.ACCESS_FINE_LOCATION)
    fun nmeaMessagesFlow(): Flow<NmeaMessage> = callbackFlow {
        if (callback == null) {
            callback = OnNmeaMessageListener { message, timestamp ->
                trySend(NmeaMessage(message, timestamp))
            }
        }
        locationManager.addNmeaListener(
            callback!!,
            null
        )

        awaitClose {
            locationManager.removeNmeaListener(callback!!)
            callback = null
        }
    }
}