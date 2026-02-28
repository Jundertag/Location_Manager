package com.jayden.locationmanager.data.model

sealed class NmeaEvent(
    val talkerId: TalkerId,
    val message: NmeaMessage
) {
}