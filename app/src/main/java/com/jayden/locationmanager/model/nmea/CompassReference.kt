package com.jayden.locationmanager.model.nmea

enum class CompassReference {
    MAGNETIC,
    TRUE;

    override fun toString(): String = when (this) {
        MAGNETIC -> "Magnetic"
        TRUE -> "True"
    }
}