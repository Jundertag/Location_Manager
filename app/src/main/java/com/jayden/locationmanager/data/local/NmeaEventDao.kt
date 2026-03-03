package com.jayden.locationmanager.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.jayden.locationmanager.data.local.NmeaEventEntity

@Dao
interface NmeaEventDao {
    @Insert
    suspend fun insertAll(vararg events: NmeaEventEntity)

    @Insert
    suspend fun insert(event: NmeaEventEntity)

    @Delete
    suspend fun delete(event: NmeaEventEntity)

    @Query("""
        SELECT * FROM nmea_events
        ORDER BY timestamp ASC, id ASC
    """)
    fun pagingSource(): PagingSource<Int, NmeaEventEntity>

    @Query("""
        DELETE FROM nmea_events WHERE timestamp < :time
    """)
    suspend fun deleteOld(time: Long): Int
}