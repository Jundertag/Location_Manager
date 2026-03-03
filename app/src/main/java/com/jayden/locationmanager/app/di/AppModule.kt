package com.jayden.locationmanager.app.di

import android.content.Context
import android.location.LocationManager
import androidx.room.Room
import com.jayden.locationmanager.data.source.AppLocationManager
import com.jayden.locationmanager.data.local.NmeaLogsDatabase
import com.jayden.locationmanager.data.local.NmeaEventDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideLocationManager(
        @ApplicationContext context: Context
    ): LocationManager = context.getSystemService(LocationManager::class.java)

    @Provides
    @Singleton
    fun provideNmeaLogsDatabase(
        @ApplicationContext context: Context
    ): NmeaLogsDatabase = Room.databaseBuilder(
        context,
        NmeaLogsDatabase::class.java,
        "nmea_logs_db"
    ).build()

    @Provides
    fun provideNmeaLogsDao(
        database: NmeaLogsDatabase
    ): NmeaEventDao = database.nmeaEventDao()

}