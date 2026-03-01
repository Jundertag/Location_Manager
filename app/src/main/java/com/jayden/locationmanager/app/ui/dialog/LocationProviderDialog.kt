package com.jayden.locationmanager.app.ui.dialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun LocationProviderDialog(
    visible: Boolean,
    title: @Composable () -> Unit = { Text("Select Provider", style = MaterialTheme.typography.titleMedium) },
    options: List<String>,
    initialSelection: String? = null,
    onConfirmSelection: ((String) -> Unit),
    onDismissDialog: () -> Unit
) {
    var selected: String? by remember(visible, initialSelection) { mutableStateOf(initialSelection) }
    if (visible) {
        Dialog(onDismissRequest = onDismissDialog) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(375.dp)
                    .padding(16.dp)
            ) {
                title()
                Spacer(Modifier.height(4.dp))
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .heightIn(max = 320.dp)
                ) {
                    items(options) { option ->
                        Row(
                            modifier = Modifier.padding(vertical = 8.dp)
                        ) {
                            RadioButton(
                                selected = (selected == option),
                                onClick = {
                                    selected = option
                                }
                            )
                            Spacer(Modifier.width(8.dp))
                            Text(option)
                        }
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    TextButton(
                        onClick = onDismissDialog,
                        modifier = Modifier.padding(8.dp)
                    ) { Text("dismiss") }
                    TextButton(
                        enabled = (selected != null),
                        onClick = { onConfirmSelection(selected!!) },
                        modifier = Modifier.padding(8.dp)
                    ) { Text("confirm") }
                }
            }
        }
    }
}