package com.jayden.locationmanager.app.ui.model.nmea

data class NmeaFieldUi(
    val name: String,
    val value: String?
) {
    override fun toString(): String {
        return "$name: ${value ?: "not provided"}"
    }
}