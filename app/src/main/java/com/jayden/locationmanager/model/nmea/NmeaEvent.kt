package com.jayden.locationmanager.model.nmea

sealed class NmeaEvent(
    val talkerId: TalkerId,
    val message: NmeaMessage
) {
}