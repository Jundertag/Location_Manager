package com.jayden.locationmanager.model.nmea.units

enum class RadiusUnit {
    NAUTICAL_MILE;

    override fun toString(): String = when (this) {
        NAUTICAL_MILE -> "Nautical Mile"
    }

}