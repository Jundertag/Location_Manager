package com.jayden.locationmanager.model.nmea

enum class GpsQualityIndicator {
    FIX_NOT_AVAILABLE,
    GPS_FIX,
    DIFFERENTIAL_GPS_FIX,
    PPS_FIX,
    REAL_TIME_KINETIC,
    FLOAT_RTK,
    ESTIMATED,
    MANUAL_INPUT_MODE,
    SIMULATION_MODE;

    override fun toString(): String = when (this) {
        FIX_NOT_AVAILABLE -> "Fix not available"
        GPS_FIX -> "GPS Fix"
        DIFFERENTIAL_GPS_FIX -> "Differential GPS Fix"
        PPS_FIX -> "PPS Fix"
        REAL_TIME_KINETIC -> "Real Time Kinetic"
        FLOAT_RTK -> "Float RTK"
        ESTIMATED -> "Estimated"
        MANUAL_INPUT_MODE -> "Manual input mode"
        SIMULATION_MODE -> "Simulation mode"
    }
}