package com.jayden.locationmanager.model.nmea.typeconverter

import com.jayden.locationmanager.model.nmea.NmeaEvent
import com.jayden.locationmanager.model.nmea.NmeaMessage
import com.jayden.locationmanager.model.nmea.NmeaSentence
import com.jayden.locationmanager.model.nmea.TalkerId

object TypeConverter {
    private val TalkerIdRegex = Regex("""^[$!].{2}""")

    fun String?.parseTalkerId(): TalkerId = when (this) {
        "AB" -> TalkerId.INDEPENDENT_AIS
        "AD" -> TalkerId.DEPENDENT_AIS
        "AG" -> TalkerId.AUTOPILOT_GENERAL
        "AI" -> TalkerId.MOBILE_AIS
        "AN" -> TalkerId.AIS_NAVIGATION_AID
        "AP" -> TalkerId.AUTOPILOT_MAGNETIC
        "AR" -> TalkerId.AIS_RECEIVING_STATION
        "AT" -> TalkerId.AIS_TRANSMITTING_STATION
        "AX" -> TalkerId.AIS_SIMPLEX_REPEATER
        "BD" -> TalkerId.BEI_DUO
        "BI" -> TalkerId.BILGE_SYSTEM
        "BN" -> TalkerId.BRIDGE_NAVIGATION_ALARM_SYSTEM
        "CA" -> TalkerId.CENTRAL_ALARM
        "CD" -> TalkerId.COMMUNICATIONS_SELECTIVE_CALLING
        "CR" -> TalkerId.DATA_RECEIVER
        "CS" -> TalkerId.COMMUNICATIONS_SATELLITE
        "CT" -> TalkerId.COMMUNICATIONS_RADIO_TELEPHONE
        "CV" -> TalkerId.COMMUNICATIONS_RADIO_TELEPHONE_VARIABLE
        "CX" -> TalkerId.COMMUNICATIONS_SCANNING_RECEIVER
        "DF" -> TalkerId.DIRECTION_FINDER
        "DM" -> TalkerId.VELOCITY_SENSOR_SPEED_LOG_WATER_MAGNETIC
        "DP" -> TalkerId.DYNAMIC_POSITION
        "DU" -> TalkerId.DUPLEX_REPEATER
        "EC" -> TalkerId.ELECTRONIC_CHART_DISPLAY_INFORMATION_SYSTEM
        "EP" -> TalkerId.EMERGENCY_POSITION_INDICATING_BEACON
        "ER" -> TalkerId.ENGINE_ROOM_MONITORING_SYSTEMS
        "FD" -> TalkerId.FIRE_DOOR
        "FS" -> TalkerId.FIRE_SPRINKLER
        "GA" -> TalkerId.GALILEO_POSITIONING_SYSTEM
        "GB" -> TalkerId.BEI_DUO
        "GI" -> TalkerId.IRNSS
        "GL" -> TalkerId.COMBINATION
        "GP" -> TalkerId.GPS_RECEIVER
        "GQ" -> TalkerId.QZSS_GPS_AUGMENTATION_SYSTEM
        "HC" -> TalkerId.HEADING_MAGNETIC_COMPASS
        "HD" -> TalkerId.HULL_DOOR
        "HE" -> TalkerId.HEADING_NORTH_SEEKING_GYRO
        "HF" -> TalkerId.HEADING_FLUXGATE
        "HN" -> TalkerId.HEADING_NON_NORTH_SEEKING_GYRO
        "HS" -> TalkerId.HULL_STRESS
        null -> TalkerId.UNKNOWN
        else -> TalkerId.UNKNOWN
    }

    fun String?.parseSentence(): NmeaSentence = when (this) {
        null -> NmeaSentence.UNKNOWN
        else -> NmeaSentence.UNKNOWN
    }

    fun getTalkerId(input: String): TalkerId {
        return if (input.contains(Regex("""^[$!]P"""))) {
            TalkerId.PROPRIETARY
        } else {
            TalkerIdRegex.find(input)?.value?.drop(1).parseTalkerId()
        }
    }

    fun String.toNmeaEvent(): NmeaEvent {
        return NmeaEvent(
            talkerId = getTalkerId(this),
            message = NmeaMessage.RawEvent(this)
        )
    }
}