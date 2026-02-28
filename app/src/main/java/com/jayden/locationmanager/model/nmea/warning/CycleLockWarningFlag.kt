package com.jayden.locationmanager.model.nmea.warning

enum class CycleLockWarningFlag {
    WARNING,
    OK;

    override fun toString(): String = when (this) {
        WARNING -> "Cycle Lock warning flag"
        OK -> "Ok (or not used)"
    }

}