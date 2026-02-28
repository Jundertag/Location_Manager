package com.jayden.locationmanager.model.nmea

data class NmeaEvent(
    val talkerId: TalkerId,
    val message: NmeaMessage
) {
    fun getPrettySentenceType(): String = when (message) {
        is NmeaMessage.AamEvent -> "AAM - Waypoint Arrival Alarm"
        is NmeaMessage.AlmEvent -> "ALM - GPS Almanac Data"
        is NmeaMessage.ApaEvent -> "APA - Autopilot Sentence \"A\""
        is NmeaMessage.ApbEvent -> "APB - Autopilot Sentence \"B\""
        is NmeaMessage.BodEvent -> "BOD - Bearing - Waypoint to Waypoint"
        is NmeaMessage.BwcEvent -> "BWC - Bearing & Distance to Waypoint - Great Circle"
        is NmeaMessage.BwrEvent -> "BWR - Bearing and Distance to Waypoint - Rhumb Line"
        is NmeaMessage.BwwEvent -> "BWW - Bearing - From Waypoint to Waypoint"
        is NmeaMessage.DbkEvent -> "DBK - Depth Below Keel"
        is NmeaMessage.DbsEvent -> "DBS - Depth Below Surface"
        is NmeaMessage.DbtEvent -> "DPT - Depth below transducer"
        is NmeaMessage.DptEvent -> "DPT - Depth of Water"
        is NmeaMessage.DtmEvent -> "DTM - datum Reference"
        is NmeaMessage.FsiEvent -> "FSI - Frequency Set Information"
        is NmeaMessage.GbsEvent -> "GBS - GPS Satellite Fault Detection"
        is NmeaMessage.GgaEvent -> "GGA - Global Positioning System Fix Data"
        is NmeaMessage.GllEvent -> "GLL - Geographic Position - Latitude/Longitude"
        is NmeaMessage.GnsEvent -> "GNS - Fix data"
        is NmeaMessage.GrsEvent -> "GRS - GPS Range Residuals"
        is NmeaMessage.ProprietaryEvent -> "Proprietary Event"
        is NmeaMessage.RawEvent -> "Raw Event"
    }
}