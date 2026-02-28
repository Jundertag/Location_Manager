package com.jayden.locationmanager.model.nmea.units

enum class CrossTrackUnit {
    NAUTICAL_MILE,
    KILOMETER;

    override fun toString(): String = when (this) {
        NAUTICAL_MILE -> "Nautical mile"
        KILOMETER -> "Kilometers"
    }
}