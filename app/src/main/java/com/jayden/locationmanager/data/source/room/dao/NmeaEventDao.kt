package com.jayden.locationmanager.data.source.room.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.jayden.locationmanager.data.source.room.entity.NmeaEventEntity

@Dao
interface NmeaEventDao {
    @Insert
    suspend fun insertAll(vararg events: NmeaEventEntity)

    @Delete
    suspend fun delete(event: NmeaEventEntity)

    @Query("""
        SELECT * FROM nmea_events
    """)
    fun pagingSource(): PagingSource<Long, NmeaEventEntity>

    @Query("""
        DELETE FROM nmea_events WHERE timestamp < :time
    """)
    suspend fun deleteOld(time: Long)
}