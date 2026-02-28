package com.jayden.locationmanager.model.nmea.indicator

enum class FaaModeIndicator {
    AUTONOMOUS_MODE,
    CAUTION,
    DIFFERENTIAL_MODE,
    ESTIMATED_MODE,
    RTK_FLOAT_MODE,
    MANUAL_INPUT_MODE,
    DATA_NOT_VALID,
    PRECISE,
    RTK_INTEGER_MODE,
    SIMULATOR_MODE,
    UNSAFE;

    override fun toString(): String = when (this) {
        AUTONOMOUS_MODE -> "Autonomous mode"
        CAUTION -> "Caution (unofficial)"
        DIFFERENTIAL_MODE -> "Differential Mode"
        ESTIMATED_MODE -> "Estimated (dead-reckoning) mode"
        RTK_FLOAT_MODE -> "RTK Float Mode"
        MANUAL_INPUT_MODE -> "Manual Input Mode"
        DATA_NOT_VALID -> "Data Not Valid"
        PRECISE -> "Precise"
        RTK_INTEGER_MODE -> "RTK Integer mode"
        SIMULATOR_MODE -> "Simulated Mode"
        UNSAFE -> "Unsafe (unofficial)"
    }


    companion object {
        fun FaaModeIndicator.isOfficial(): Boolean = when (this) {
            AUTONOMOUS_MODE -> true
            DIFFERENTIAL_MODE -> true
            ESTIMATED_MODE -> true
            RTK_FLOAT_MODE -> true
            MANUAL_INPUT_MODE -> true
            DATA_NOT_VALID -> true
            PRECISE -> true
            RTK_INTEGER_MODE -> true
            SIMULATOR_MODE -> true

            CAUTION -> false
            UNSAFE -> false
        }

        fun FaaModeIndicator.isUnofficial(): Boolean = !this.isOfficial()
    }
}