package com.jayden.locationmanager.data.source.room.dao

import androidx.room.Dao
import androidx.room.Insert
import com.jayden.locationmanager.data.source.room.entity.NmeaEventEntity

@Dao
interface NmeaEventDao {
    @Insert
    fun insertAll(vararg events: NmeaEventEntity)
}