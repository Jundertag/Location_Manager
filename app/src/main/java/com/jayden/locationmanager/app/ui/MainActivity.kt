package com.jayden.locationmanager.app.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.jayden.locationmanager.app.MainApp
import com.jayden.locationmanager.app.ui.navigation.NavigationRoot
import com.jayden.locationmanager.app.ui.theme.AppTheme
import com.jayden.locationmanager.app.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: MainViewModel by viewModels()
        setContent {
            AppTheme {
                NavigationRoot(
                    app = (application as MainApp)
                )
            }
        }
    }
}