package com.jayden.locationmanager.app.ui.screen

import android.Manifest
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.jayden.locationmanager.app.MainApp
import com.jayden.locationmanager.app.ui.model.nmea.UiTypeConverter.toUi
import com.jayden.locationmanager.app.viewmodel.NmeaLogsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NmeaLogsScreen(
    modifier: Modifier = Modifier,
    app: MainApp,
    onBack: () -> Unit
) {
    val context = LocalContext.current

    val viewModel: NmeaLogsViewModel = viewModel(
        factory = app.nmeaLogsViewModelFactory
    )

    val logs = viewModel.pagingFlow.collectAsLazyPagingItems()

    val permissionLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
            if (granted) {
                viewModel.initializeNmeaLogging()
            } else {
                Toast.makeText(context, "Precise location required to record logs", Toast.LENGTH_LONG).show()
            }
        }

    if (ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    ) {
        viewModel.initializeNmeaLogging()
    } else {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clickable { permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION) }
        ) {
            Text("Precise location required to show logs")
        }
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(
            logs.itemCount
        ) { index ->
            val log = logs[index]!!
            val event = log.toUi()

            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Column(
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(log.getPrettySentenceType(), style = MaterialTheme.typography.titleMedium)
                    Spacer(Modifier.height(8.dp))

                }
            }
        }
    }
}