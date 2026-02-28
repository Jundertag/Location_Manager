package com.jayden.locationmanager.data.source.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "nmea_event",
)
data class NmeaEventEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val timestamp: Long = System.currentTimeMillis(),
    val event: String
)