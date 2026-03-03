package com.jayden.locationmanager.data.model

data class Coordinate(
    val latitude: Double,
    val longitude: Double,
    val bearing: Float?,
    val provider: String?
)
