package com.jayden.locationmanager.data.source.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jayden.locationmanager.data.source.room.dao.NmeaEventDao
import com.jayden.locationmanager.data.source.room.entity.NmeaEventEntity

@Database(
    version = 1,
    entities = [NmeaEventEntity::class],
    exportSchema = true
)
abstract class NmeaLogsDatabase : RoomDatabase() {
    abstract fun nmeaEventDao(): NmeaEventDao
}