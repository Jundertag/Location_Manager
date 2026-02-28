package com.jayden.locationmanager.data.model

enum class ModeIndicator {
    AUTONOMOUS,
    DIFFERENTIAL,
    ESTIMATED,
    RTK_FLOAT,
    MANUAL_INPUT,
    NOT_IN_USE_OR_NO_VALID_FIX,
    PRECISE,
    RTK_INTEGER,
    SIMULATOR;

    override fun toString(): String {
        return when (this) {
            AUTONOMOUS -> "Autonomous"
            DIFFERENTIAL -> "Differential mode"
            ESTIMATED -> "Estimated mode"
            RTK_FLOAT -> "RTK float"
            MANUAL_INPUT -> "Manual input mode"
            NOT_IN_USE_OR_NO_VALID_FIX -> "Constellation not in use, or no valid fix"
            PRECISE -> "Precise"
            RTK_INTEGER -> "RTK integer"
            SIMULATOR -> "Simulator mode"
        }
    }
}