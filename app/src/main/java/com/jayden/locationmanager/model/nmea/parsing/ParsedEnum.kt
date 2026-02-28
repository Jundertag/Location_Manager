package com.jayden.locationmanager.model.nmea.parsing

data class ParsedEnum<T>(
    val value: T?,
    val raw: String?
) {
    override fun toString(): String {
        return when {
            value != null -> value.toString()
            raw != null -> "Unknown value ($raw)"
            else -> "Field not present"
        }
    }
}