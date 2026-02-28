package com.jayden.locationmanager.model.nmea.typeconverter

import com.jayden.locationmanager.model.nmea.NmeaEvent
import com.jayden.locationmanager.model.nmea.NmeaMessage
import com.jayden.locationmanager.model.nmea.NmeaSentence
import com.jayden.locationmanager.model.nmea.TalkerId

object TypeConverter {
    private val TalkerIdRegex = Regex("""^[$!](.{2})""")
    private val SentenceTypeRegex = Regex("""^[$!].{2}(.{3})""")

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
        "AAM" -> NmeaSentence.WAYPOINT_ARRIVAL_ALARM
        "ALM" -> NmeaSentence.GPS_ALMANAC_DATA
        "APA" -> NmeaSentence.AUTOPILOT_SENTENCE_A
        "APB" -> NmeaSentence.AUTOPILOT_SENTENCE_B
        "BOD" -> NmeaSentence.BEARING_WAYPOINT_TO_WAYPOINT
        "BWC" -> NmeaSentence.BEARING_DISTANCE_TO_WAYPOINT_CIRCLE
        "BWR" -> NmeaSentence.BEARING_DISTANCE_TO_WAYPOINT_LINE
        "DBK" -> NmeaSentence.DEPTH_BELOW_KEEL
        "DBS" -> NmeaSentence.DEPTH_BELOW_SURFACE
        "DBT" -> NmeaSentence.DEPTH_BELOW_TRANSDUCER
        "DPT" -> NmeaSentence.DEPTH_OF_WATER
        "DTM" -> NmeaSentence.DATUM_REFERENCE
        "FSI" -> NmeaSentence.FREQUENCY_SET_INFORMATION
        "GBS" -> NmeaSentence.GPS_SATELLITE_FAULT_DETECTION
        "GGA" -> NmeaSentence.GLOBAL_POSITIONING_SYSTEM_FIX_DATA
        "GLC" -> NmeaSentence.GEOGRAPHIC_POSITION
        "GNS" -> NmeaSentence.FIX_DATA
        "GRS" -> NmeaSentence.GPS_RANGE_RESIDUALS
        "GST" -> NmeaSentence.GPS_PSEUDORANGE_NOISE_STATISTICS
        "GSA" -> NmeaSentence.GPS_DOP_AND_ACTIVE_SATELLITES
        "GSV" -> NmeaSentence.SATELLITES_IN_VIEW
        "GTD" -> NmeaSentence.GEOGRAPHIC_LOCATION_TIME_DIFFERENCES
        "GXA" -> NmeaSentence.TRANSIT_POSITION
        "HDG" -> NmeaSentence.HEADING_DEVIATION_VARIATION
        "HDM" -> NmeaSentence.HEADING_MAGNETIC
        "HDT" -> NmeaSentence.HEADING_TRUE
        "HFB" -> NmeaSentence.TRAWL_HEADROPE_TO_FOOTROPE_AND_BOTTOM
        "HSC" -> NmeaSentence.HEADING_STEERING_COMMAND
        "ITS" -> NmeaSentence.TRAWL_DOOR_SPREAD_2_DISTANCE
        "MSK" -> NmeaSentence.CONTROL_BEACON_RECEIVER
        "MSS" -> NmeaSentence.BEACON_RECEIVER_STATUS
        "MTW" -> NmeaSentence.MEAN_TEMPERATURE_OF_WATER
        "MWD" -> NmeaSentence.WIND_DIRECTION_AND_SPEED
        "MWV" -> NmeaSentence.WIND_SPEED_AND_ANGLE
        "OSD" -> NmeaSentence.OWN_SHIP_DATA
        "R00" -> NmeaSentence.WAYPOINTS_IN_ACTIVE_ROUTE
        "RLM" -> NmeaSentence.RETURN_LINK_MESSAGE
        "RMA" -> NmeaSentence.RECOMMENDED_MINIMUM_NAVIGATION_INFORMATION
        "RMB" -> NmeaSentence.RECOMMENDED_MINIMUM_NAVIGATION_RECEIVER_INFORMATION
        "RMC" -> NmeaSentence.RECOMMENDED_MINIMUM_NAVIGATION_GPS_INFORMATION
        "ROT" -> NmeaSentence.RATE_OF_TURN
        "RPM" -> NmeaSentence.REVOLUTIONS
        "RSA" -> NmeaSentence.RUDDER_SENSOR_ANGLE
        "RSD" -> NmeaSentence.RADAR_SYSTEM_DATA
        "RTE" -> NmeaSentence.ROUTES
        "SFI" -> NmeaSentence.SCANNING_FREQUENCY_INFORMATION
        "STN" -> NmeaSentence.MULTIPLE_DATA_ID
        "TDS" -> NmeaSentence.TRAWL_DOOR_SPREAD_DISTANCE
        "TFI" -> NmeaSentence.TRAWL_FILLING_INDICATOR
        "TLB" -> NmeaSentence.TARGET_LABEL
        "TLL" -> NmeaSentence.TARGET_LATITUDE_LONGITUDE
        "TPC" -> NmeaSentence.TRAWL_POSITION_CARTESIAN_COORDINATES
        "TPR" -> NmeaSentence.TRAWL_POSITION_RELATIVE_VESSEL
        "TPT" -> NmeaSentence.TRAWL_POSITION_TRUE
        "TRF" -> NmeaSentence.TRANSIT_FIX_DATA
        "TTM" -> NmeaSentence.TRACKED_TARGET_MESSAGE
        "VBW" -> NmeaSentence.DUAL_GROUND_WATER_SPEED
        "VDR" -> NmeaSentence.SET_AND_DRIFT
        "VHW" -> NmeaSentence.WATER_SPEED_AND_HEADING
        "VLW" -> NmeaSentence.DISTANCED_TRAVELLED_THROUGH_WATER
        "VPW" -> NmeaSentence.SPEED_PARALLEL_TO_WIND
        "VTG" -> NmeaSentence.TRACK_GROUND_SPEED
        "VWR" -> NmeaSentence.RELATIVE_WIND_SPEED_AND_ANGLE
        "WCV" -> NmeaSentence.WAYPOINT_CLOSURE_VELOCITY
        "WNC" -> NmeaSentence.DISTANCE_WAYPOINT_TO_WAYPOINT
        "WPL" -> NmeaSentence.WAYPOINT_LOCATION
        "XDR" -> NmeaSentence.TRANSDUCER_MEASUREMENT
        "XTE" -> NmeaSentence.CROSS_TRACK_MEASURED_ERROR
        "XTR" -> NmeaSentence.CROSS_TRACK_DEAD_RECKONING_ERROR
        "ZDA" -> NmeaSentence.TIME_AND_DATE
        "ZFO" -> NmeaSentence.TIME_FROM_ORIGIN_WAYPOINT
        "ZTG" -> NmeaSentence.TIME_TO_DESTINATION_WAYPOINT
        null -> NmeaSentence.UNKNOWN
        else -> NmeaSentence.PROPRIETARY_EVENT
    }

    fun getTalkerId(input: String): TalkerId {
        return if (input.contains(Regex("""^[$!]P"""))) {
            TalkerId.PROPRIETARY
        } else {
            TalkerIdRegex.find(input)?.groupValues?.getOrNull(1).parseTalkerId()
        }
    }

    fun getSentenceType(input: String): NmeaSentence {
        return if (input.contains(Regex("""^[$!]P"""))) {
            NmeaSentence.PROPRIETARY_EVENT
        } else {
            SentenceTypeRegex.find(input)?.groupValues?.getOrNull(1).parseSentence()
        }
    }

    fun String.toNmeaEvent(): NmeaEvent {
        return NmeaEvent(
            talkerId = getTalkerId(this),
            sentenceType = getSentenceType(this),
            message = NmeaMessage.RawEvent(this)
        )
    }
}