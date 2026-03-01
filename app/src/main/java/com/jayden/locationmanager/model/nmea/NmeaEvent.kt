package com.jayden.locationmanager.model.nmea

data class NmeaEvent(
    internal val id: Long,
    val talkerId: TalkerId,
    val sentenceType: NmeaSentence,
    val message: NmeaMessage
) {
    fun getPrettySentenceType(): String = sentenceType.toString()
}