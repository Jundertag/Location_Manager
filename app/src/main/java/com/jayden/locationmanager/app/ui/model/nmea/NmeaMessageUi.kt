package com.jayden.locationmanager.app.ui.model.nmea

import com.jayden.locationmanager.model.nmea.TalkerId

data class NmeaMessageUi(
    val title: String,
    val talkerId: TalkerId,
    val fields: List<NmeaFieldUi>
)