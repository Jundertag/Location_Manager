package com.jayden.locationmanager.app.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jayden.locationmanager.app.MainApp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NmeaLogsScreen(
    modifier: Modifier = Modifier,
    app: MainApp
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {

    }
}