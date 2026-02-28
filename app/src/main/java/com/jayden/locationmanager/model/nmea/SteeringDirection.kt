package com.jayden.locationmanager.model.nmea

enum class SteeringDirection {
    LEFT,
    RIGHT;

    override fun toString(): String = when (this) {
        LEFT -> "Left"
        RIGHT -> "Right"
    }
}