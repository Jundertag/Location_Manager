package com.jayden.locationmanager.model.nmea

enum class NavigationStatus {
    SAFE,
    CAUTION,
    UNSAFE,
    NOT_VALID;

    override fun toString(): String {
        return when (this) {
            SAFE -> "Safe"
            CAUTION -> "Caution"
            UNSAFE -> "Unsafe"
            NOT_VALID -> "Not valid for navigation"
        }
    }
}