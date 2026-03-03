package com.jayden.locationmanager.data.repo

import android.Manifest
import androidx.annotation.RequiresPermission
import com.jayden.locationmanager.data.source.AppLocationManager
import com.jayden.locationmanager.data.source.AppNmeaLogsManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.shareIn
import javax.inject.Inject

class LocationRepo @Inject constructor(
    private val scope: CoroutineScope,
    private val appLocationManager: AppLocationManager,
    private val appNmeaLogsManager: AppNmeaLogsManager
) {
    @RequiresPermission(anyOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    fun getLocation(
        provider: String,
        minTimeMs: Long,
        minDistanceM: Float
    ) = appLocationManager.locationUpdatesFlow(
        provider,
        minTimeMs,
        minDistanceM
    ).shareIn(
        scope,
        started = SharingStarted.WhileSubscribed(5_000),
        replay = 0
    )

    @RequiresPermission(Manifest.permission.ACCESS_FINE_LOCATION)
    fun getNmeaLogs() = appNmeaLogsManager
        .nmeaMessagesFlow()
        .shareIn(
            scope,
            started = SharingStarted.WhileSubscribed(5_000),
            replay = 0
        )
}