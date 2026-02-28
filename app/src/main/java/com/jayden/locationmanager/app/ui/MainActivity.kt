package com.jayden.locationmanager.app.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import com.jayden.locationmanager.app.MainApp
import com.jayden.locationmanager.app.ui.navigation.NavigationRoot
import com.jayden.locationmanager.app.ui.theme.AppTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                NavigationRoot(
                    app = (application as MainApp)
                )
            }
        }
    }
}