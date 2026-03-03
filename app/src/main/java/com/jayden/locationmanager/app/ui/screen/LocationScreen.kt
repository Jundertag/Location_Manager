package com.jayden.locationmanager.app.ui.screen

import android.Manifest
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jayden.locationmanager.app.ui.dialog.LocationProviderDialog
import com.jayden.locationmanager.app.viewmodel.MainViewModel
import com.jayden.locationmanager.data.model.Coordinate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel,
    locationProvider: String,
) {
    val context = LocalContext.current

    val permissionLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { result ->
            val fineLocationGranted = result[Manifest.permission.ACCESS_FINE_LOCATION] == true
            val coarseLocationGranted = result[Manifest.permission.ACCESS_COARSE_LOCATION] == true

            if (fineLocationGranted || coarseLocationGranted) {
                // TODO: granted location permissions
            } else {
                Toast.makeText(context, "Permissions not granted", Toast.LENGTH_SHORT).show()
            }
        }

    val coarseLocationGranted by remember(context) { mutableStateOf(
        ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED)
    }
    val fineLocationGranted by remember(context) { mutableStateOf(
        ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED)
    }

    var requestedLocationProvider: String by remember { mutableStateOf(locationProvider) }
    var showProviderDialog: Boolean by rememberSaveable { mutableStateOf(false) }

    val location: Coordinate by viewModel.getLocation(
        provider = requestedLocationProvider
    ).collectAsStateWithLifecycle(
        initialValue = Coordinate(
            latitude = 0.0,
            longitude = 0.0,
            bearing = 0f,
            provider = ""
        ),
        minActiveState = Lifecycle.State.RESUMED
    )

    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .combinedClickable(
                onClick = {
                    if (!fineLocationGranted) {
                        permissionLauncher.launch(
                            arrayOf(
                                Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.ACCESS_COARSE_LOCATION
                            )
                        )
                    }
                },
                onLongClick = {
                    showProviderDialog = true
                }
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    "Current Location",
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    location.provider ?: "unknown provider",
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Text(
                "Latitude: ${location.latitude}",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                "Longitude: ${location.longitude}",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                "Bearing: ${location.bearing}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}