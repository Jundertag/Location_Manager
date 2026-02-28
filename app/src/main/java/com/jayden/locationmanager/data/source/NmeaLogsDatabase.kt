package com.jayden.locationmanager.data.source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jayden.locationmanager.data.source.room.dao.NmeaEventDao

@Database(version = 1, entities = [])
abstract class NmeaLogsDatabase : RoomDatabase() {
    abstract fun nmeaEventDao(): NmeaEventDao
}