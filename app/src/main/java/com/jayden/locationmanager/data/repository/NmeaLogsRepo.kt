package com.jayden.locationmanager.data.repository

import androidx.paging.PagingSource
import com.jayden.locationmanager.data.source.room.dao.NmeaEventDao
import com.jayden.locationmanager.data.source.room.entity.NmeaEventEntity

class NmeaLogsRepo(
    val dao: NmeaEventDao
) {
    fun pagingSource(): PagingSource<Long, NmeaEventEntity> = dao.pagingSource()
}