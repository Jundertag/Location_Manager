package com.jayden.locationmanager.app.ui.screen

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.rememberLifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import com.jayden.locationmanager.app.MainApp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NmeaLogsScreen(
    modifier: Modifier = Modifier,
    app: MainApp,
    viewModel: NmeaLogsViewModel = hiltViewModel(),
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

    val lazyListState = rememberLazyListState(
        logs.itemCount
    )

    val isAtBottom by remember {
        derivedStateOf {
            val layoutInfo = lazyListState.layoutInfo
            val totalItems = layoutInfo.totalItemsCount
            val lastVisible = layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: 0
            lastVisible >= totalItems - 1
        }
    }

    val lifecycleOwner = rememberLifecycleOwner()

    if (fineLocationGranted) {
        Box(Modifier.fillMaxSize()) {
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                state = lazyListState,
            ) {
                // TODO: New log screen implementation
            }

            AnimatedVisibility(
                visible = !isAtBottom,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(16.dp),
                enter = slideInVertically {
                    -40
                } + expandVertically(
                    expandFrom = Alignment.Bottom
                ) + fadeIn(
                    initialAlpha = 0.3f
                ),
                exit = slideOutVertically {
                    -40
                } + shrinkVertically() + fadeOut()
            ) {
                Surface(
                    tonalElevation = 6.dp,
                    shape = MaterialTheme.shapes.extraLarge
                ) {
                    TextButton(
                        onClick = {
                            lifecycleOwner.lifecycleScope.launch {
                                lazyListState.scrollToItem(
                                    lazyListState.layoutInfo.totalItemsCount
                                )
                            }
                        }
                    ) {
                        Text("Jump to Newest Logs")
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