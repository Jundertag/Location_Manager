package com.jayden.locationmanager.app.ui.screen

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberOverscrollEffect
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import com.jayden.locationmanager.app.MainApp
import com.jayden.locationmanager.app.ui.model.nmea.UiTypeConverter.toUi
import com.jayden.locationmanager.app.viewmodel.NmeaLogsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NmeaLogsScreen(
    modifier: Modifier = Modifier,
    app: MainApp,
    viewModel: NmeaLogsViewModel = viewModel(
        factory = app.nmeaLogsViewModelFactory
    ),
    onBack: () -> Unit
) {
    val context = LocalContext.current

    val logs = viewModel.pagingFlow.collectAsLazyPagingItems()

    var fineLocationGranted by remember { mutableStateOf(ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) }

    val permissionLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
            fineLocationGranted = granted
            if (granted) {
                @SuppressLint("MissingPermission")
                viewModel.initializeNmeaLogging()
            } else {
                Toast.makeText(context, "Precise location required to record logs", Toast.LENGTH_LONG).show()
            }
        }

    if (fineLocationGranted) {
        @SuppressLint("MissingPermission")
        viewModel.initializeNmeaLogging()
    }

    val lazyListState = rememberLazyListState()

    if (fineLocationGranted) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            state = lazyListState,
        ) {
            items(
                count = logs.itemCount,
                key = logs.itemKey { it.id },
                contentType = { index ->
                    val item = logs[index]
                    when {
                        item == null -> "placeholder"
                        else -> "event"
                    }
                }
            ) { index ->
                val log = logs[index]

                if (log == null) {
                    ElevatedCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp, bottom = 12.dp)
                    ) {
                        Box(
                            modifier = Modifier.height(72.dp).fillMaxWidth()
                        ) {
                            LinearProgressIndicator(
                                modifier = Modifier.fillMaxWidth().align(Alignment.TopCenter)
                            )

                            Text(
                                "Loading",
                                modifier = Modifier.align(Alignment.TopStart),
                                style = MaterialTheme.typography.titleLarge
                            )
                        }
                    }
                } else {
                    val event = log.toUi()
                    ElevatedCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp, bottom = 12.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(12.dp)
                        ) {
                            Text(
                                log.getPrettySentenceType(),
                                style = MaterialTheme.typography.titleMedium
                            )
                            Text(
                                log.talkerId.toString(),
                                style = MaterialTheme.typography.bodyMedium
                            )

                            Spacer(Modifier.height(8.dp))
                            event.fields.forEach { field ->
                                Text(field.toString(), style = MaterialTheme.typography.bodySmall)
                            }
                        }
                    }
                }
            }
        }
    } else {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clickable { permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION) }
        ) {
            Text(
                "Precise location required to show logs",
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 6.dp)
            )
        }
    }
}