package com.jayden.locationmanager.model.nmea

data class NmeaEvent(
    val talkerId: TalkerId,
    val message: NmeaMessage
) {
}