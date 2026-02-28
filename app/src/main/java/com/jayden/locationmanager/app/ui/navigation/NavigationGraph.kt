package com.jayden.locationmanager.app.ui.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface NavigationGraph : NavKey {
    @Serializable
    data object Location : NavigationGraph
    @Serializable
    data object NmeaLogs : NavigationGraph
}