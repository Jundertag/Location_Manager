package com.jayden.locationmanager.app.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.jayden.locationmanager.app.MainApp
import com.jayden.locationmanager.app.viewmodel.NmeaLogsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NmeaLogsScreen(
    modifier: Modifier = Modifier,
    app: MainApp,
    onBack: () -> Unit
) {
    val viewModel: NmeaLogsViewModel = viewModel(
        factory = app.nmeaLogsViewModelFactory
    )

    val logs = viewModel.pagingFlow.collectAsLazyPagingItems()

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(
            logs.itemCount
        ) { index ->
            val log = logs[index]

        }
    }
}