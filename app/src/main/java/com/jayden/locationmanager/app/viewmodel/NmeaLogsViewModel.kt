package com.jayden.locationmanager.app.viewmodel

import android.Manifest
import androidx.annotation.RequiresPermission
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jayden.locationmanager.data.repository.NmeaLogsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NmeaLogsViewModel @Inject constructor(
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