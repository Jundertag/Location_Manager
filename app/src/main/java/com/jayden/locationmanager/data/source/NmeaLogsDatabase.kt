package com.jayden.locationmanager.data.source

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(version = 1, entities = [])
abstract class NmeaLogsDatabase : RoomDatabase() {
}