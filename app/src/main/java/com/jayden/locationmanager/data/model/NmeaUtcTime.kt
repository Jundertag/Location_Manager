package com.jayden.locationmanager.data.model

data class NmeaUtcTime(
    val hours: Int,
    val minutes: Int,
    val seconds: Int,
    val milli: Int = 0
)