package com.jayden.locationmanager.data.repository

import android.Manifest
import androidx.annotation.RequiresPermission
import androidx.paging.PagingSource
import com.jayden.locationmanager.data.source.AppNmeaLogsListener
import com.jayden.locationmanager.data.source.room.dao.NmeaEventDao
import com.jayden.locationmanager.data.source.room.entity.NmeaEventEntity
import com.jayden.locationmanager.model.nmea.NmeaEvent
import com.jayden.locationmanager.model.nmea.typeconverter.TypeConverter.toNmeaEvent

class NmeaLogsRepo(
    val dao: NmeaEventDao,
    val listener: AppNmeaLogsListener
) {
    fun pagingSource(): PagingSource<Long, NmeaEventEntity> = dao.pagingSource()
    suspend fun deleteOlder(time: Long): Int = dao.deleteOld(time)

    @RequiresPermission(Manifest.permission.ACCESS_FINE_LOCATION)
    fun listenToNmeaMessages(
        receiver: (NmeaEvent) -> Unit
    ) {
        listener.listenForNmeaMessages { message ->
            receiver(message.toNmeaEvent())
        }
    }
}