package com.jayden.locationmanager.model.nmea

data class NmeaEvent(
    val talkerId: TalkerId,
    val sentenceType: NmeaSentence,
    val message: NmeaMessage
) {
    fun getPrettySentenceType(): String = sentenceType.toString()
}