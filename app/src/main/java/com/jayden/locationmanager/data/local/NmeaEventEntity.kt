package com.jayden.locationmanager.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "nmea_events",
)
data class NmeaEventEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val timestamp: Long = System.currentTimeMillis(),
    val event: String
)