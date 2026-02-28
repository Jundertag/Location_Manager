package com.jayden.locationmanager.model.nmea

enum class NmeaSentence {
    WAYPOINT_ARRIVAL_ALARM,
    GPS_ALMANAC_DATA,
    AUTOPILOT_SENTENCE_A,
    AUTOPILOT_SENTENCE_B,
    BEARING_WAYPOINT_TO_WAYPOINT,
    BEARING_DISTANCE_TO_WAYPOINT_CIRCLE,
    BEARING_DISTANCE_TO_WAYPOINT_LINE,
    DEPTH_BELOW_KEEL,
    DEPTH_BELOW_SURFACE,
    DEPTH_BELOW_TRANSDUCER,
    DEPTH_OF_WATER,
    DATUM_REFERENCE,
    FREQUENCY_SET_INFORMATION,
    GPS_SATELLITE_FAULT_DETECTION,
    GLOBAL_POSITIONING_SYSTEM_FIX_DATA,
    GEOGRAPHIC_POSITION,
    FIX_DATA,
    GPS_RANGE_RESIDUALS,
    GPS_PSEUDORANGE_NOISE_STATISTICS,
    GPS_DOP_AND_ACTIVE_SATELLITES,
    SATELLITES_IN_VIEW,
    GEOGRAPHIC_LOCATION_TIME_DIFFERENCES,
    TRANSIT_POSITION,
    HEADING_DEVIATION_VARIATION,
    HEADING_MAGNETIC,
    HEADING_TRUE,
    TRAWL_HEADROPE_TO_FOOTROPE_AND_BOTTOM,
    HEADING_STEERING_COMMAND,
    UNKNOWN,
    TRAWL_DOOR_SPREAD_2_DISTANCE,
    CONTROL_BEACON_RECEIVER,
    BEACON_RECEIVER_STATUS,
    MEAN_TEMPERATURE_OF_WATER,
    WIND_DIRECTION_AND_SPEED,
    WIND_SPEED_AND_ANGLE,
    OWN_SHIP_DATA,
    WAYPOINTS_IN_ACTIVE_ROUTE,
    RETURN_LINK_MESSAGE,
    RECOMMENDED_MINIMUM_NAVIGATION_INFORMATION,
    RECOMMENDED_MINIMUM_NAVIGATION_RECEIVER_INFORMATION,
    RECOMMENDED_MINIMUM_NAVIGATION_GPS_INFORMATION,
    RATE_OF_TURN,
    REVOLUTIONS,
    RUDDER_SENSOR_ANGLE,
    RADAR_SYSTEM_DATA,
    ROUTES,
    SCANNING_FREQUENCY_INFORMATION,
    MULTIPLE_DATA_ID,
    TRAWL_DOOR_SPREAD_DISTANCE,
    TRAWL_FILLING_INDICATOR,
    TARGET_LABEL,
    TARGET_LATITUDE_LONGITUDE,
    TRAWL_POSITION_CARTESIAN_COORDINATES,
    TRAWL_POSITION_RELATIVE_VESSEL,
    TRAWL_POSITION_TRUE,
    TRANSIT_FIX_DATA,
    TRACKED_TARGET_MESSAGE,
    DUAL_GROUND_WATER_SPEED,
    SET_AND_DRIFT,
    WATER_SPEED_AND_HEADING,
    DISTANCED_TRAVELLED_THROUGH_WATER,
    SPEED_PARALLEL_TO_WIND,
    TRACK_GROUND_SPEED,
    RELATIVE_WIND_SPEED_AND_ANGLE,
    WAYPOINT_CLOSURE_VELOCITY,
    DISTANCE_WAYPOINT_TO_WAYPOINT,
    WAYPOINT_LOCATION,
    TRANSDUCER_MEASUREMENT,
    CROSS_TRACK_MEASURED_ERROR,
    CROSS_TRACK_DEAD_RECKONING_ERROR,
    TIME_AND_DATE,
    TIME_FROM_ORIGIN_WAYPOINT,
    TIME_TO_DESTINATION_WAYPOINT,
    RAW_EVENT,
    PROPRIETARY_EVENT;

    override fun toString(): String = when (this) {
        WAYPOINT_ARRIVAL_ALARM -> "AAM - Waypoint Arrival Alarm"
        GPS_ALMANAC_DATA -> "ALM - GPS Almanac Data"
        AUTOPILOT_SENTENCE_A -> "APA - Autopilot Sentence \"A\""
        AUTOPILOT_SENTENCE_B -> "APB - Autopilot Sentence \"B\""
        BEARING_WAYPOINT_TO_WAYPOINT -> "BOD - Bearing - Waypoint to Waypoint"
        BEARING_DISTANCE_TO_WAYPOINT_CIRCLE -> "BWC - Bearing & Distance to Waypoint - Great Circle"
        BEARING_DISTANCE_TO_WAYPOINT_LINE -> "BWR - Bearing and Distance to Waypoint - Rhumb Line"
        DEPTH_BELOW_KEEL -> "DBK - Depth Below Keel"
        DEPTH_BELOW_SURFACE -> "DBS - Depth Below Surface"
        DEPTH_BELOW_TRANSDUCER -> "DBT - Depth below transducer"
        DEPTH_OF_WATER -> "DPT - Depth of Water"
        DATUM_REFERENCE -> "DTM - Datum Reference"
        FREQUENCY_SET_INFORMATION -> "FSI - Frequency Set Information"
        GPS_SATELLITE_FAULT_DETECTION -> "GBS - GPS Satellite Fault Detection"
        GLOBAL_POSITIONING_SYSTEM_FIX_DATA -> "GGA - Global Positioning System Fix Data"
        GEOGRAPHIC_POSITION -> "GLC - Geographic Position, Latitude/Longitude"
        FIX_DATA -> "GNS - Fix data"
        GPS_RANGE_RESIDUALS -> "GRS - GPS Range Residuals"
        GPS_PSEUDORANGE_NOISE_STATISTICS -> "GST - GPS Pseudorange Noise Statistics"
        GPS_DOP_AND_ACTIVE_SATELLITES -> "GSA - GPS DOP and active satellites"
        SATELLITES_IN_VIEW -> "GSV - Satellites in view"
        GEOGRAPHIC_LOCATION_TIME_DIFFERENCES -> "GTD - Geographic Location in Time Differences"
        TRANSIT_POSITION -> "GXA - TRANSIT Position - Latitude/Longitude"
        HEADING_DEVIATION_VARIATION -> "HDG - Heading - Deviation & Variation"
        HEADING_MAGNETIC -> "HDM - Heading - Magnetic"
        HEADING_TRUE -> "HDT - Heading - True"
        TRAWL_HEADROPE_TO_FOOTROPE_AND_BOTTOM -> "HFB - Trawl Headrope to Footrope and Bottom"
        HEADING_STEERING_COMMAND -> "HSC - Heading Steering Command"
        UNKNOWN -> "Unknown Event"
        TRAWL_DOOR_SPREAD_2_DISTANCE -> "ITS - Trawl Door Spread 2 Distance"
        CONTROL_BEACON_RECEIVER -> "MSK - Control for a Beacon Receiver"
        BEACON_RECEIVER_STATUS -> "MSS - Beacon Receiver Status"
        MEAN_TEMPERATURE_OF_WATER -> "MTW - Mean Temperature of Water"
        WIND_DIRECTION_AND_SPEED -> "MWD - Wind Direction & Speed"
        WIND_SPEED_AND_ANGLE -> "MWV - Wind Speed and Angle"
        OWN_SHIP_DATA -> "OSD - Own Ship Data"
        WAYPOINTS_IN_ACTIVE_ROUTE -> "R00 - Waypoints in active route"
        RETURN_LINK_MESSAGE -> "RLM - Return Link Message"
        RECOMMENDED_MINIMUM_NAVIGATION_INFORMATION -> "RMA - Recommended Minimum Navigation Information"
        RECOMMENDED_MINIMUM_NAVIGATION_RECEIVER_INFORMATION -> "RMB - Recommended Minimum Navigation Information"
        RECOMMENDED_MINIMUM_NAVIGATION_GPS_INFORMATION -> "RMC - Recommended Minimum Navigation Information"
        RATE_OF_TURN -> "ROT - Rate Of Turn"
        REVOLUTIONS -> "RPM - Revolutions"
        RUDDER_SENSOR_ANGLE -> "RSA - Rudder Sensor Angle"
        RADAR_SYSTEM_DATA -> "RSD - RADAR System Data"
        ROUTES -> "RTE - Routes"
        SCANNING_FREQUENCY_INFORMATION -> "SFI - Scanning Frequency Information"
        MULTIPLE_DATA_ID -> "STN - Multiple Data ID"
        TRAWL_DOOR_SPREAD_DISTANCE -> "TDS - Trawl Door Spread Distance"
        TRAWL_FILLING_INDICATOR -> "TFI - Trawl Filling Indicator"
        TARGET_LABEL -> "TLB - Target Label"
        TARGET_LATITUDE_LONGITUDE -> "TLL - Target Latitude and Longitude"
        TRAWL_POSITION_CARTESIAN_COORDINATES -> "TPC - Trawl Position Cartesian Coordinates"
        TRAWL_POSITION_RELATIVE_VESSEL -> "TPR - Trawl Position Relative Vessel"
        TRAWL_POSITION_TRUE -> "TPT - Trawl Position True"
        TRANSIT_FIX_DATA -> "TRF - TRANSIT Fix Data"
        TRACKED_TARGET_MESSAGE -> "TTM - Tracked Target Message"
        DUAL_GROUND_WATER_SPEED -> "VBW - Dual Ground/Water Speed"
        SET_AND_DRIFT -> "VDR - Set and Drift"
        WATER_SPEED_AND_HEADING -> "VHW - Water speed and heading"
        DISTANCED_TRAVELLED_THROUGH_WATER -> "VLW - Distance Travelled through Water"
        SPEED_PARALLEL_TO_WIND -> "VPW - Speed - Measured Parallel to Wind"
        TRACK_GROUND_SPEED -> "VTG - Track made good and Ground speed"
        RELATIVE_WIND_SPEED_AND_ANGLE -> "VWR - Relative Wind Speed and Angle"
        WAYPOINT_CLOSURE_VELOCITY -> "WCV - Waypoint Closure Velocity"
        DISTANCE_WAYPOINT_TO_WAYPOINT -> "WNC - Distance - Waypoint to Waypoint"
        WAYPOINT_LOCATION -> "WPL - Waypoint Location"
        TRANSDUCER_MEASUREMENT -> "XDR - Transducer Measurement"
        CROSS_TRACK_MEASURED_ERROR -> "XTE - Cross-Track Error, Measured"
        CROSS_TRACK_DEAD_RECKONING_ERROR -> "XTR - Cross Track Error - Dead Reckoning"
        TIME_AND_DATE -> "ZDA - Time & Date - UTC, day, month, year and local time zone"
        TIME_FROM_ORIGIN_WAYPOINT -> "ZFO - UTC & Time from origin Waypoint"
        TIME_TO_DESTINATION_WAYPOINT -> "ZTG - UTC & Time to Destination Waypoint"
        RAW_EVENT -> "Raw Event"
        PROPRIETARY_EVENT -> "Proprietary Event"
    }
}