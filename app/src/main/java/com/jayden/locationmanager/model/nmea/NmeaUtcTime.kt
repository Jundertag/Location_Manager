package com.jayden.locationmanager.model.nmea

data class NmeaUtcTime(
    val hours: Int,
    val minutes: Int,
    val seconds: Int,
    val milli: Int = 0
)