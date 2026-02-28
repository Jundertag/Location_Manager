package com.jayden.locationmanager.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jayden.locationmanager.data.repository.NmeaLogsRepo
import kotlinx.coroutines.launch

class NmeaLogsViewModel(
    private val repo: NmeaLogsRepo
) : ViewModel() {
    val pagingSource = repo.pagingSource()

    fun deleteOlder(time: Long) {
        viewModelScope.launch {
            repo.deleteOlder(time)
        }
    }
}