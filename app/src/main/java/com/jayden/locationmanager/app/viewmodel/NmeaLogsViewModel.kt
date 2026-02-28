package com.jayden.locationmanager.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.jayden.locationmanager.data.repository.NmeaLogsRepo
import kotlinx.coroutines.launch

class NmeaLogsViewModel(
    private val repo: NmeaLogsRepo
) : ViewModel() {
    val pagingFlow = Pager(
        config = PagingConfig(
            pageSize = 10
        ),
        pagingSourceFactory = { repo.pagingSource() }
    ).flow

    fun deleteOlder(time: Long) {
        viewModelScope.launch {
            repo.deleteOlder(time)
        }
    }
}