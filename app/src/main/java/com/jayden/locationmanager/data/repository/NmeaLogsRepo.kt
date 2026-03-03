package com.jayden.locationmanager.data.repository

import android.Manifest
import androidx.annotation.RequiresPermission
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.map
import com.jayden.locationmanager.data.source.AppNmeaLogsListener
import com.jayden.locationmanager.data.local.NmeaEventDao
import com.jayden.locationmanager.data.local.NmeaEventEntity
import com.jayden.locationmanager.model.nmea.typeconverter.TypeConverter.toNmeaEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class NmeaLogsRepo @Inject constructor(
    val dao: NmeaEventDao,
    val listener: AppNmeaLogsListener
) {
    fun pagingFlow() = Pager(
        config = PagingConfig(
            pageSize = 10
        ),
        pagingSourceFactory = { dao.pagingSource() }
    ).flow
        .map { pagingData ->
            pagingData.map { entity ->
                entity.event
            }
        }
    suspend fun deleteOlder(time: Long): Int = dao.deleteOld(time)

    @RequiresPermission(Manifest.permission.ACCESS_FINE_LOCATION)
    fun initializeNmeaLogging(
        scope: CoroutineScope
    ) {
        listener.listenForNmeaMessages { message ->
            scope.launch {
                dao.insert(NmeaEventEntity(event = message))
            }
        }
    }
}