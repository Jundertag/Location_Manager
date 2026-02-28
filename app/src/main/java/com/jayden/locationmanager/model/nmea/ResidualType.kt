package com.jayden.locationmanager.model.nmea

enum class ResidualType {
    USED_IN_GGA,
    CALCULATED_AFTER_GGA;

    override fun toString(): String = when (this) {
        USED_IN_GGA -> "Residuals used in GGA"
        CALCULATED_AFTER_GGA -> "Residuals calculated after GGA"
    }
}