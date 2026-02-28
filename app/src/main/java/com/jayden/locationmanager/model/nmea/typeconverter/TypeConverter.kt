package com.jayden.locationmanager.model.nmea.typeconverter

import com.jayden.locationmanager.model.nmea.NmeaEvent
import com.jayden.locationmanager.model.nmea.NmeaMessage
import com.jayden.locationmanager.model.nmea.TalkerId

object TypeConverter {
    fun String.toNmeaEvent(): NmeaEvent {
        return NmeaEvent(
            talkerId = TalkerId.UNKNOWN,
            message = NmeaMessage.RawEvent(this)
        )
    }
}