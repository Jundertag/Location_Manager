package com.jayden.locationmanager.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jayden.locationmanager.data.local.NmeaEventDao
import com.jayden.locationmanager.data.local.NmeaEventEntity

@Database(
    version = 1,
    entities = [NmeaEventEntity::class],
    exportSchema = true
)
abstract class NmeaLogsDatabase : RoomDatabase() {
    abstract fun nmeaEventDao(): NmeaEventDao
}