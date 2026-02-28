package com.jayden.locationmanager.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jayden.locationmanager.data.repository.LocationRepo

class LocationViewModelFactory(
    private val repo: LocationRepo
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return LocationViewModel(repo) as T
    }
}