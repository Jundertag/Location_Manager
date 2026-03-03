package com.jayden.locationmanager.data.model

import android.location.Location

data class Coordinate(
    val latitude: Double,
    val longitude: Double,
    val bearing: Float?,
    val provider: String?
)

fun Location.toCoordinate(): Coordinate = Coordinate(latitude, longitude, bearing, provider)