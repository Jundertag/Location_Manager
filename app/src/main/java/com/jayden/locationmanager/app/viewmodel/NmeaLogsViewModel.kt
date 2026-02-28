package com.jayden.locationmanager.app.viewmodel

import android.Manifest
import androidx.annotation.RequiresPermission
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.jayden.locationmanager.app.ui.model.nmea.NmeaMessageUi
import com.jayden.locationmanager.data.repository.NmeaLogsRepo
import com.jayden.locationmanager.model.nmea.NmeaEvent
import kotlinx.coroutines.launch

class NmeaLogsViewModel(
    private val repo: NmeaLogsRepo
) : ViewModel() {
    val pagingFlow = repo.pagingFlow()

    @RequiresPermission(Manifest.permission.ACCESS_FINE_LOCATION)
    fun initializeNmeaLogging() {
        repo.initializeNmeaLogging(viewModelScope)
    }

    fun deleteOlder(time: Long) {
        viewModelScope.launch {
            repo.deleteOlder(time)
        }
    }
}