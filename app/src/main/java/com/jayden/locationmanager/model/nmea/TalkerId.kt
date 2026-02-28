package com.jayden.locationmanager.model.nmea

enum class TalkerId {
    INDEPENDENT_AIS,
    DEPENDENT_AIS,
    AUTOPILOT_GENERAL,
    MOBILE_AIS,
    AIS_NAVIGATION_AID,
    AUTOPILOT_MAGNETIC,
    AIS_RECEIVING_STATION,
    AIS_TRANSMITTING_STATION,
    AIS_SIMPLEX_REPEATER,
    BEI_DUO,
    BILGE_SYSTEM,
    BRIDGE_NAVIGATION_ALARM_SYSTEM,
    CENTRAL_ALARM,
    COMMUNICATIONS_SELECTIVE_CALLING,
    DATA_RECEIVER,
    COMMUNICATIONS_SATELLITE,
    COMMUNICATIONS_RADIO_TELEPHONE,
    COMMUNICATIONS_RADIO_TELEPHONE_VARIABLE,
    COMMUNICATIONS_SCANNING_RECEIVER,
    DIRECTION_FINDER,
    VELOCITY_SENSOR_SPEED_LOG_WATER_MAGNETIC,
    DYNAMIC_POSITION,
    DUPLEX_REPEATER,
    ELECTRONIC_CHART_DISPLAY_INFORMATION_SYSTEM,
    EMERGENCY_POSITION_INDICATING_BEACON,
    ENGINE_ROOM_MONITORING_SYSTEMS,
    FIRE_DOOR,
    FIRE_SPRINKLER,
    GALILEO_POSITIONING_SYSTEM,
    IRNSS,
    GLONASS,
    COMBINATION,
    GPS_RECEIVER,
    QZSS_GPS_AUGMENTATION_SYSTEM,
    HEADING_MAGNETIC_COMPASS,
    HULL_DOOR,
    HEADING_NORTH_SEEKING_GYRO,
    HEADING_FLUXGATE,
    HEADING_NON_NORTH_SEEKING_GYRO,
    HULL_STRESS,
    INTEGRATED_INSTRUMENTATION,
    INTEGRATED_NAVIGATION,
    ALARM_MONITORING,
    WATER_MONITORING,
    POWER_MANAGEMENT,
    PROPULSION_CONTROL,
    ENGINE_CONTROL,
    PROPULSION_BOILER,
    AUX_BOILER,
    ENGINE_GOVERNOR,
    MULTIPLEXER,
    NAVIGATION_LIGHT_CONTROLLER,
    PROPRIETARY,
    RADAR_ARPA,
    RECORD_BOOK,
    PROPULSION_MACHINERY,
    RUDDER_ANGLE_INDICATOR,
    PHYSICAL_SHORE_AUS_STATION,
    DEPTH_SOUNDER,
    STEERING_GEAR,
    ELECTRONIC_POSITIONING_SYSTEM,
    SCANNING_SOUNDER,
    SKYTRAQ_DEBUG_OUTPUT,
    TRACK_CONTROL,
    TURN_RATE_INDICATOR,
    TRANSIT_NAVIGATION_SYSTEM,
    USER_CONFIGURED,
    MICROPROCESSOR_CONTROLLER,
    VHF_DATA_EXCHANGE_SYSTEM,
    VELOCITY_SENSOR_DOPPLER,
    VOYAGE_DATA_RECORDER,
    VHF_DATA_EXCHANGE_SYSTEM_SATELLITE,
    VHF_DATA_EXCHANGE_SYSTEM_TERRESTRIAL,
    VELOCITY_SENSOR_SPEED_LOG_WATER_MECHANICAL,
    WATERTIGHT_DOOR,
    WEATHER_INSTRUMENTS,
    WATER_LEVEL,
    TRANSDUCER,
    TIMEKEEPER_ATOMIC_CLOCK,
    TIMEKEEPER_CHRONOMETER,
    TIMEKEEPER_QUARTZ,
    TIMEKEEPER_RADIO_UPDATE_WWV_WWVH;

    override fun toString(): String = when (this) {
        INDEPENDENT_AIS -> "Independent AIS Base Station"
        DEPENDENT_AIS -> "Dependent AIS Base Station"
        AUTOPILOT_GENERAL -> "Autopilot - General"
        MOBILE_AIS -> "Mobile AIS Station"
        AIS_NAVIGATION_AID -> "AID Aid to Navigation"
        AUTOPILOT_MAGNETIC -> "Autopilot - Magnetic"
        AIS_RECEIVING_STATION -> "AIS Receiving Station"
        AIS_TRANSMITTING_STATION -> "AIS Transmitting Station"
        AIS_SIMPLEX_REPEATER -> "AIS Simplex Repeater"
        BEI_DUO -> "BeiDuo (China)"
        BILGE_SYSTEM -> "Bilge System"
        BRIDGE_NAVIGATION_ALARM_SYSTEM -> "Bridge navigational watch alarm system"
        CENTRAL_ALARM -> "Central Alarm"
        COMMUNICATIONS_SELECTIVE_CALLING -> "Communications - Digital Selective Calling (DSC)"
        DATA_RECEIVER -> "Data Receiver"
        COMMUNICATIONS_SATELLITE -> "Communications - Satellite"
        COMMUNICATIONS_RADIO_TELEPHONE -> "Communications - Radio Telephone (MF/HF)"
        COMMUNICATIONS_RADIO_TELEPHONE_VARIABLE -> "Communications - Radio Telephone (VHF)"
        COMMUNICATIONS_SCANNING_RECEIVER -> "Communications - Scanning Receiver"
        DIRECTION_FINDER -> "Direction Finder"
        VELOCITY_SENSOR_SPEED_LOG_WATER_MAGNETIC -> "Velocity Sensor, Speed Log, Water, Magnetic"
        DYNAMIC_POSITION -> "Dynamic Position"
        DUPLEX_REPEATER -> "Duplex repeater station"
        ELECTRONIC_CHART_DISPLAY_INFORMATION_SYSTEM -> "Electronic Chart Display & Information System (ECDIS)"
        EMERGENCY_POSITION_INDICATING_BEACON -> "Emergency Position Indicating Beacon (EPIRB)"
        ENGINE_ROOM_MONITORING_SYSTEMS -> "Engine Room Monitoring Systems"
        FIRE_DOOR -> "Fire Door"
        FIRE_SPRINKLER -> "Fire Sprinkler"
        GALILEO_POSITIONING_SYSTEM -> "Galileo Positioning System"
        IRNSS -> "NavIC, IRNSS (India)"
        GLONASS -> "GLONASS"
        COMBINATION -> "Combination of multiple satellite systems"
        GPS_RECEIVER -> "Global Positioning System (GPS) receiver"
        QZSS_GPS_AUGMENTATION_SYSTEM -> "QZSS Regional GPS augmentation system (Japan)"
        HEADING_MAGNETIC_COMPASS -> "Heading - Magnetic Compass"
        HULL_DOOR -> "Hull Door"
        HEADING_NORTH_SEEKING_GYRO -> "Heading - North Seeking Gyro"
        HEADING_FLUXGATE -> "Heading - Fluxgate"
        HEADING_NON_NORTH_SEEKING_GYRO -> "Heading - Non North Seeking Gyro"
        HULL_STRESS -> "Hull Stress"
        INTEGRATED_INSTRUMENTATION -> "Integrated Instrumentation"
        INTEGRATED_NAVIGATION -> "Integrated Navigation"
        ALARM_MONITORING -> "Alarm and Monitoring"
        WATER_MONITORING -> "Water Monitoring"
        POWER_MANAGEMENT -> "Power Management"
        PROPULSION_CONTROL -> "Propulsion Control"
        ENGINE_CONTROL -> "Engine Control"
        PROPULSION_BOILER -> "Propulsion Boiler"
        AUX_BOILER -> "Aux Boiler"
        ENGINE_GOVERNOR -> "Engine Governor"
        MULTIPLEXER -> "Multiplexer"
        NAVIGATION_LIGHT_CONTROLLER -> "Navigation light controller"
        PROPRIETARY -> "Proprietary protocol"
        RADAR_ARPA -> "RADAR and/or ARPA"
        RECORD_BOOK -> "Record Book"
        PROPULSION_MACHINERY -> "Propulsion Machinery"
        RUDDER_ANGLE_INDICATOR -> "Rudder Angle Indicator"
        PHYSICAL_SHORE_AUS_STATION -> "Physical Shore AUS Station"
        DEPTH_SOUNDER -> "Depth Sounder"
        STEERING_GEAR -> "Steering Gear"
        ELECTRONIC_POSITIONING_SYSTEM -> "Electronic Positioning System, other/general"
        SCANNING_SOUNDER -> "Scanning Sounder"
        SKYTRAQ_DEBUG_OUTPUT -> "Skytraq debug output"
        TRACK_CONTROL -> "Track Control"
        TURN_RATE_INDICATOR -> "Turn Rate Indicator"
        TRANSIT_NAVIGATION_SYSTEM -> "TRANSIT Navigation System"
        USER_CONFIGURED -> "User Configured"
        MICROPROCESSOR_CONTROLLER -> "Microprocessor controller"
        VHF_DATA_EXCHANGE_SYSTEM -> "VHF Data Exchange System (VDES), ASM"
        VELOCITY_SENSOR_DOPPLER -> "Velocity Sensor, Doppler, other/general"
        VOYAGE_DATA_RECORDER -> "Voyage Data recorder"
        VHF_DATA_EXCHANGE_SYSTEM_SATELLITE -> "VHF Data Exchange System (VDES), Sattelite"
        VHF_DATA_EXCHANGE_SYSTEM_TERRESTRIAL -> "VHF Data Exchange System (VDES), Terrestrial"
        VELOCITY_SENSOR_SPEED_LOG_WATER_MECHANICAL -> "Velocity Sensor, Speed Log, Water, Mechanical"
        WATERTIGHT_DOOR -> "Watertight Door"
        WEATHER_INSTRUMENTS -> "Weather Instruments"
        WATER_LEVEL -> "Water Level"
        TRANSDUCER -> "Transducer"
        TIMEKEEPER_ATOMIC_CLOCK -> "Timekeeper - Atomic Clock"
        TIMEKEEPER_CHRONOMETER -> "Timekeeper - Chronometer"
        TIMEKEEPER_QUARTZ -> "Timekeeper - Quartz"
        TIMEKEEPER_RADIO_UPDATE_WWV_WWVH -> "Timekeeper - Radio Update, WWV or WWVH"
    }
}