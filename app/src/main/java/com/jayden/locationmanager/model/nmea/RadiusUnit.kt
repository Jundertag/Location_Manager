package com.jayden.locationmanager.model.nmea

enum class RadiusUnit {
    NAUTICAL_MILE;

    override fun toString(): String {
        return when (this) {
            NAUTICAL_MILE -> "Nautical Mile"
        }
    }
}