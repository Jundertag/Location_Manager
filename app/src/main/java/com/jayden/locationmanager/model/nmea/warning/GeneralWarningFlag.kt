package com.jayden.locationmanager.model.nmea.warning

enum class GeneralWarningFlag {
    WARNING_FIX_NOT_AVAILABLE,
    DATA_VALID;

    override fun toString(): String {
        return when (this) {
            WARNING_FIX_NOT_AVAILABLE -> "Reliable fix not available"
            DATA_VALID -> "Data valid"
        }
    }
}