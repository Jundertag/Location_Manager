package com.jayden.locationmanager.data.di

import android.content.Context
import com.jayden.locationmanager.data.repo.LocationRepo
import com.jayden.locationmanager.data.source.AppLocationManager
import com.jayden.locationmanager.data.source.AppNmeaLogsManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideCoroutineScope() = CoroutineScope(SupervisorJob() + Dispatchers.Main)

    @Provides
    fun provideAppLocationManager(
        @ApplicationContext context: Context
    ): AppLocationManager = AppLocationManager(context)

    @Provides
    fun provideAppNmeaLogsManager(
        @ApplicationContext context: Context,
    ): AppNmeaLogsManager = AppNmeaLogsManager(context)
}