package com.jayden.locationmanager.app.viewmodel

import androidx.lifecycle.ViewModel
import com.jayden.locationmanager.data.repository.LocationRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: LocationRepo
) : ViewModel() {

}