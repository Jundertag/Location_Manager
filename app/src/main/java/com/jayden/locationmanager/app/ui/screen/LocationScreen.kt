package com.jayden.locationmanager.app.ui.screen

import android.Manifest
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jayden.locationmanager.app.MainApp
import com.jayden.locationmanager.app.ui.dialog.LocationProviderDialog
import com.jayden.locationmanager.app.viewmodel.LocationViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationScreen(
    modifier: Modifier = Modifier,
    app: MainApp,
    locationProvider: String,
) {
    val viewModel: LocationViewModel = viewModel(
        factory = app.locationViewModelFactory
    )
    val context = LocalContext.current

    val permissionLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { result ->
            val fineLocationGranted = result[Manifest.permission.ACCESS_FINE_LOCATION] == true
            val coarseLocationGranted = result[Manifest.permission.ACCESS_COARSE_LOCATION] == true

            if (fineLocationGranted || coarseLocationGranted) {
                viewModel.retrieveCachedLocation()
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

    val location by viewModel.locationFlow(
        provider = requestedLocationProvider
    ).collectAsStateWithLifecycle(
        minActiveState = Lifecycle.State.RESUMED
    )

    LocationProviderDialog(
        visible = showProviderDialog,
        options = viewModel.allLocationProviders,
        initialSelection = requestedLocationProvider,
        onConfirmSelection = {
            requestedLocationProvider = it
            showProviderDialog = false
            viewModel.restartLocationFlow()
        },
        onDismissDialog = {
            showProviderDialog = false
        }
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
        val bearing = location?.let {
            if (it.bearing == null) {
                if (ContextCompat.checkSelfPermission(
                        context,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED) {
                    "not available (need precise location)"
                } else {
                    "not available (not reported by hardware)" // assume not available
                }
            } else {
                "${it.bearing}°"
            }
        }

        Text(
            "Current Location",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(12.dp)
        )
        Spacer(Modifier.height(2.dp))
        if (location == null) {
            val unavailableReason = when {
                ContextCompat.checkSelfPermission(
                        context,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED -> "(need permission)"
                else -> ""
            }
            Text(
                "Location Unavailable $unavailableReason",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .padding(horizontal = 12.dp)
            )
        } else {
            Text(
                "provider: ${location!!.provider ?: "unknown"}",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .padding(horizontal = 12.dp)
            )
            Text(
                "latitude: ${location!!.latitude}°",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .padding(horizontal = 12.dp)
            )
            Text(
                "longitude: ${location!!.longitude}°",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .padding(horizontal = 12.dp)
            )
            Text(
                "direction of travel: $bearing",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
            )
        }
    }
}