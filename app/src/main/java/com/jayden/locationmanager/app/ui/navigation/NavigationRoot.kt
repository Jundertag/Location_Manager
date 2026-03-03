package com.jayden.locationmanager.app.ui.navigation

import android.location.LocationManager
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.jayden.locationmanager.R
import com.jayden.locationmanager.app.MainApp
import com.jayden.locationmanager.app.ui.screen.LocationScreen
import com.jayden.locationmanager.app.ui.screen.NmeaLogsScreen
import com.jayden.locationmanager.app.viewmodel.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationRoot(
    modifier: Modifier = Modifier,
    app: MainApp,
) {
    val backStack = rememberNavBackStack(
        NavigationGraph.Location
    )

    var locationProvider by remember { mutableStateOf(LocationManager.GPS_PROVIDER) }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("${backStack.last()}", style = MaterialTheme.typography.titleLarge) })
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = (backStack.last() == NavigationGraph.Location),
                    onClick = {
                        backStack.add(NavigationGraph.Location)
                    },
                    icon = {
                        Icon(
                            modifier = Modifier
                                .size(24.dp),
                            painter = if (backStack.last() == NavigationGraph.Location) {
                                painterResource(R.drawable.ic_location_filled)
                            } else {
                                painterResource(R.drawable.ic_location)
                            },
                            contentDescription = "Location Destination"
                        )
                    }
                )
                NavigationBarItem(
                    selected = (backStack.last() == NavigationGraph.NmeaLogs),
                    onClick = {
                        backStack.add(NavigationGraph.NmeaLogs)
                    },
                    icon = {
                        Icon(
                            modifier = Modifier
                                .size(24.dp),
                            painter = if (backStack.last() == NavigationGraph.NmeaLogs) {
                                painterResource(R.drawable.ic_structured_data_filled)
                            } else {
                                painterResource(R.drawable.ic_structured_data)
                            },
                            contentDescription = "Location Destination"
                        )
                    }
                )
            }
        },
    ) { padding ->
        NavDisplay(
            backStack = backStack,
            entryDecorators = listOf(
                rememberSaveableStateHolderNavEntryDecorator(),
                rememberViewModelStoreNavEntryDecorator(),
            ),
            modifier = Modifier.padding(padding),
            onBack = {
                if (backStack.size > 1) {
                    backStack.removeLastOrNull()
                }
            },
        ) { key ->
            when (key) {
                is NavigationGraph.Location -> NavEntry(key = key) {
                    LocationScreen(
                        app = app,
                        locationProvider = locationProvider,
                    )
                }

                is NavigationGraph.NmeaLogs -> NavEntry(key = key) {
                    NmeaLogsScreen(
                        app = app,
                        onBack = {}
                    )
                }

                else -> throw RuntimeException("Not a valid NavigationGraph destination $key")
            }
        }
    }
}

private const val TAG = "NavigationRoot"