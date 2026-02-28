package com.jayden.locationmanager.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jayden.locationmanager.data.repository.NmeaLogsRepo

class NmeaLogsViewModelFactory(
    private val repo: NmeaLogsRepo
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return NmeaLogsViewModel(
            repo
        ) as T
    }
}