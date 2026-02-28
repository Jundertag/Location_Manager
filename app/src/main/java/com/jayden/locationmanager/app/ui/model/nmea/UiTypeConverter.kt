package com.jayden.locationmanager.app.ui.model.nmea

import com.jayden.locationmanager.model.nmea.NmeaEvent
import com.jayden.locationmanager.model.nmea.NmeaMessage

object UiTypeConverter {
    fun NmeaEvent.toUi(): NmeaMessageUi = when (this.message) {
        is NmeaMessage.AamEvent -> {
            NmeaMessageUi(title = this.getPrettySentenceType(), fields = listOf(
                NmeaFieldUi(name = "Arrived", value = this.message.arrivalCircleEntered?.toString()),
                NmeaFieldUi(name = "Passed Destination", value = this.message.perpendicularPassed?.toString()),
                NmeaFieldUi(name = "Arrived Radius", value = this.message.arrivalCircleRadius?.toString()),
                NmeaFieldUi(name = "Waypoint ID", value = this.message.waypointId),
                NmeaFieldUi(name = "Checksum", value = this.message.checksum?.toString()),
            ))
        }
        is NmeaMessage.AlmEvent -> {
            NmeaMessageUi(title = this.getPrettySentenceType(), fields = listOf(
                NmeaFieldUi(name = "Message count", value = this.message.messageCount?.toString()),
                NmeaFieldUi(name = "Sentence Number", value = this.message.sentenceNumber?.toString()),
                NmeaFieldUi(name = "Satellite PRN Number", value = this.message.satellitePrnNumber?.toString()),
                NmeaFieldUi(name = "GPS Week Number", value = this.message.gpsWeekNumber?.toString()),
                NmeaFieldUi(name = "SV Health bitflags", value = this.message.svHealth?.toString()),
                NmeaFieldUi(name = "Eccentricity", value = this.message.eccentricity?.toString()),
                NmeaFieldUi(name = "Almanac Reference Time", value = this.message.almanacReferenceTime?.toString()),
                NmeaFieldUi(name = "Inclination angle", value = this.message.inclinationAngle?.toString()),
                NmeaFieldUi(name = "Rate of Right Ascension", value = this.message.rateOfRightAscension?.toString()),
                NmeaFieldUi(name = "Semi-major axis root", value = this.message.rootOfSemiMajorAxis?.toString()),
                NmeaFieldUi(name = "Argument of perigee", value = this.message.argumentOfPerigee?.toString()),
                NmeaFieldUi(name = "Longitude of ascension node", value = this.message.longitudeOfAscensionNode?.toString()),
                NmeaFieldUi(name = "Mean anomaly", value = this.message.meanAnomaly?.toString()),
                NmeaFieldUi(name = "F0 Clock Parameter", value = this.message.f0ClockParam?.toString()),
                NmeaFieldUi(name = "F1 Clock Parameter", value = this.message.f1ClockParam?.toString()),
                NmeaFieldUi(name = "Checksum", value = this.message.checksum?.toString()),
            ))
        }
        is NmeaMessage.ApaEvent -> {
            NmeaMessageUi(title = this.getPrettySentenceType(), fields = listOf(
                NmeaFieldUi(name = "General Warning", value = this.message.generalWarning?.toString()),
                NmeaFieldUi(name = "Cycle Lock Warning", value = this.message.cycleLockWarning?.toString()),
                NmeaFieldUi(name = "Cross Track Error Magnitude", value = this.message.crossTrackErrorMagnitude?.toString()),
                NmeaFieldUi(name = "Direction to Steer", value = this.message.steeringDirection?.toString()),
                NmeaFieldUi(name = "Cross Track Units", value = this.message.crossTrackUnit?.toString()),
                NmeaFieldUi(name = "Arrived", value = this.message.arrivalCircleEntered?.toString()),
                NmeaFieldUi(name = "Passed Destination", value = this.message.perpendicularPassed?.toString()),
                NmeaFieldUi(name = "Bearing origin to destination", value = this.message.bearing?.toString()),
                NmeaFieldUi(name = "Bearing type", value = this.message.bearingReference?.toString()),
                NmeaFieldUi(name = "Destination ID", value = this.message.destinationId),
                NmeaFieldUi(name = "Checksum", value = this.message.checksum?.toString()),
            ))
        }
        is NmeaMessage.ApbEvent -> {
            NmeaMessageUi(title = this.getPrettySentenceType(), fields = listOf(
                NmeaFieldUi(name = "General Warning", value = this.message.generalWarning?.toString()),
                NmeaFieldUi(name = "Cycle Lock Warning", value = this.message.cycleLockWarning?.toString()),
                NmeaFieldUi(name = "Cross Track Error Magnitude", value = this.message.crossTrackErrorMagnitude?.toString()),
                NmeaFieldUi(name = "Direction to Steer", value = this.message.steeringDirection?.toString()),
                NmeaFieldUi(name = "Cross Track Units", value = this.message.crossTrackUnit?.toString()),
                NmeaFieldUi(name = "Arrived", value = this.message.arrivalCircleEntered?.toString()),
                NmeaFieldUi(name = "Passed Destination", value = this.message.perpendicularPassed?.toString()),
                NmeaFieldUi(name = "Bearing origin to destination", value = this.message.bearingOrigin?.toString()),
                NmeaFieldUi(name = "Bearing origin type", value = this.message.bearingOriginReference?.toString()),
                NmeaFieldUi(name = "Destination ID", value = this.message.destinationId),
                NmeaFieldUi(name = "Bearing present to destination", value = this.message.bearingPresent?.toString()),
                NmeaFieldUi(name = "Bearing present type", value = this.message.bearingPresentReference?.toString()),
                NmeaFieldUi(name = "Bearing heading to destination", value = this.message.bearingHeading?.toString()),
                NmeaFieldUi(name = "Bearing heading type", value = this.message.bearingHeadingReference?.toString()),
                NmeaFieldUi(name = "Checksum", value = this.message.checksum?.toString()),
            ))
        }
        is NmeaMessage.BodEvent -> {
            NmeaMessageUi(title = this.getPrettySentenceType(), fields = listOf(
                NmeaFieldUi(name = "True Bearing", value = this.message.trueBearing?.toString()),
                NmeaFieldUi(name = "Magnetic Bearing", value = this.message.magneticBearing?.toString()),
                NmeaFieldUi(name = "Destination Waypoint ID", value = this.message.destinationWaypointId),
                NmeaFieldUi(name = "Origin Waypoint ID", value = this.message.originWaypointId),
                NmeaFieldUi(name = "Checksum", value = this.message.checksum?.toString()),
            ))
        }
        is NmeaMessage.BwcEvent -> {
            NmeaMessageUi(title = this.getPrettySentenceType(), fields = listOf(
                NmeaFieldUi(name = "UTC Time or observation", value = this.message.utcTime?.toString()),
                NmeaFieldUi(name = "Waypoint Latitude", value = this.message.waypointLatitude?.toString()),
                NmeaFieldUi(name = "Waypoint Longitude", value = this.message.waypointLongitude?.toString()),
                NmeaFieldUi(name = "True Bearing", value = this.message.trueBearing?.toString()),
                NmeaFieldUi(name = "Magnetic Bearing", value = this.message.magneticBearing?.toString()),
                NmeaFieldUi(name = "Waypoint Distance", value = this.message.distanceToWaypoint?.toString()),
                NmeaFieldUi(name = "Waypoint ID", value = this.message.waypointId),
                NmeaFieldUi(name = "FAA Mode Indicator", value = this.message.faaModeIndicator?.toString()),
                NmeaFieldUi(name = "Checksum", value = this.message.checksum?.toString()),
            ))
        }
        is NmeaMessage.BwrEvent -> {
            NmeaMessageUi(title = this.getPrettySentenceType(), fields = listOf(
                NmeaFieldUi(name = "UTC Time or observation", value = this.message.utcTime?.toString()),
                NmeaFieldUi(name = "Waypoint Latitude", value = this.message.waypointLatitude?.toString()),
                NmeaFieldUi(name = "Waypoint Longitude", value = this.message.waypointLongitude?.toString()),
                NmeaFieldUi(name = "True Bearing", value = this.message.trueBearing?.toString()),
                NmeaFieldUi(name = "Magnetic Bearing", value = this.message.magneticBearing?.toString()),
                NmeaFieldUi(name = "Waypoint Distance", value = this.message.distanceToWaypoint?.toString()),
                NmeaFieldUi(name = "Waypoint ID", value = this.message.waypointId),
                NmeaFieldUi(name = "FAA Mode Indicator", value = this.message.faaModeIndicator?.toString()),
                NmeaFieldUi(name = "Checksum", value = this.message.checksum?.toString()),
            ))
        }
        is NmeaMessage.BwwEvent -> {
            NmeaMessageUi(title = this.getPrettySentenceType(), fields = listOf(
                NmeaFieldUi(name = "True Bearing", value = this.message.trueBearing?.toString()),
                NmeaFieldUi(name = "Magnetic Bearing", value = this.message.magneticBearing?.toString()),
                NmeaFieldUi(name = "Destination Waypoint ID", value = this.message.destinationWaypointId),
                NmeaFieldUi(name = "Origin Waypoint ID", value = this.message.originWaypointId),
                NmeaFieldUi(name = "Checksum", value = this.message.checksum?.toString()),
            ))
        }
        is NmeaMessage.DbkEvent -> {
            NmeaMessageUi(title = this.getPrettySentenceType(), fields = listOf(
                NmeaFieldUi(name = "Depth in Feet", value = this.message.depthFeet?.toString()),
                NmeaFieldUi(name = "Depth in Meters", value = this.message.depthMeters?.toString()),
                NmeaFieldUi(name = "Depth in Fathoms", value = this.message.depthFathoms?.toString()),
                NmeaFieldUi(name = "Checksum", value = this.message.checksum?.toString()),
            ))
        }
        is NmeaMessage.DbsEvent -> {
            NmeaMessageUi(title = this.getPrettySentenceType(), fields = listOf(
                NmeaFieldUi(name = "Depth in Feet", value = this.message.depthFeet?.toString()),
                NmeaFieldUi(name = "Depth in Meters", value = this.message.depthMeters?.toString()),
                NmeaFieldUi(name = "Depth in Fathoms", value = this.message.depthFathoms?.toString()),
                NmeaFieldUi(name = "Checksum", value = this.message.checksum?.toString()),
            ))
        }
        is NmeaMessage.DbtEvent -> {
            NmeaMessageUi(title = this.getPrettySentenceType(), fields = listOf(
                NmeaFieldUi(name = "Depth in Feet", value = this.message.depthFeet?.toString()),
                NmeaFieldUi(name = "Depth in Meters", value = this.message.depthMeters?.toString()),
                NmeaFieldUi(name = "Depth in Fathoms", value = this.message.depthFathoms?.toString()),
                NmeaFieldUi(name = "Checksum", value = this.message.checksum?.toString()),
            ))
        }
        is NmeaMessage.DptEvent -> {
            NmeaMessageUi(title = this.getPrettySentenceType(), fields = listOf(
                NmeaFieldUi(name = "Water Depth", value = this.message.waterDepthMeters?.toString()?.plus(" m")),
                NmeaFieldUi(name = "Transducer Offset", value = this.message.transducerOffsetMeters?.toString()?.plus(" m")),
                NmeaFieldUi(name = "Maximum range", value = this.message.maxRangeScale?.toString()),
                NmeaFieldUi(name = "Checksum", value = this.message.checksum?.toString()),
            ))
        }
        is NmeaMessage.DtmEvent -> {
            NmeaMessageUi(title = this.getPrettySentenceType(), fields = listOf(
                NmeaFieldUi(name = "Datum Code", value = this.message.datumCode),
                NmeaFieldUi(name = "Datum Sub-code", value = this.message.datumSubcode),
                NmeaFieldUi(name = "Latitude Offset ", value = this.message.latitudeOffsetMinutes?.toString()?.plus(" min")),
                NmeaFieldUi(name = "Longitude Offset", value = this.message.longitudeOffsetMinutes?.toString()?.plus(" min")),
                NmeaFieldUi(name = "Altitude Offset", value = this.message.altitudeOffset?.toString()?.plus(" m")),
                NmeaFieldUi(name = "Datum Name", value = this.message.datumName),
                NmeaFieldUi(name = "Checksum", value = this.message.checksum?.toString()),
            ))
        }
        is NmeaMessage.FsiEvent -> {
            NmeaMessageUi(title = this.getPrettySentenceType(), fields = listOf(
                NmeaFieldUi(name = "Transmitting Frequency", value = this.message.transmittingFrequency?.toString()),
                NmeaFieldUi(name = "Receiving Frequency", value = this.message.receivingFrequency?.toString()),
                NmeaFieldUi(name = "Communications Mode", value = this.message.communicationsMode),
                NmeaFieldUi(name = "Power Level", value = this.message.powerLevel?.toString()),
                NmeaFieldUi(name = "Checksum", value = this.message.checksum?.toString()),
            ))
        }
        is NmeaMessage.GbsEvent -> {
            NmeaMessageUi(title = this.getPrettySentenceType(), fields = listOf(
                NmeaFieldUi(name = "UTC Time of GGA or GNS fix", value = this.message.utcTimeOfGnsFix?.toString()),
                NmeaFieldUi(name = "Latitude Error", value = this.message.latitudeErrorMeters?.toString()?.plus(" m")),
                NmeaFieldUi(name = "Longitude Error", value = this.message.longitudeErrorMeters?.toString()?.plus(" m")),
                NmeaFieldUi(name = "Altitude Error", value = this.message.altitudeErrorMeters?.toString()?.plus(" m")),
                NmeaFieldUi(name = "Failed Satellite ID", value = this.message.failedSatelliteId?.toString()),
                NmeaFieldUi(name = "Missed Detection Probability", value = this.message.missedDetectionProbability?.toString()),
                NmeaFieldUi(name = "Bias Estimate", value = this.message.failedSatelliteBiasMeters?.toString()?.plus(" m")),
                NmeaFieldUi(name = "Standard Deviation of Bias", value = this.message.biasStandardDeviationMeters?.toString()?.plus(" m")),
                NmeaFieldUi(name = "Checksum", value = this.message.checksum?.toString()),
            ))
        }
        is NmeaMessage.GgaEvent -> {
            NmeaMessageUi(title = this.getPrettySentenceType(), fields = listOf(
                NmeaFieldUi(name = "TODO", value = null),
                NmeaFieldUi(name = "Checksum", value = this.message.checksum?.toString()),
            ))
        }
        is NmeaMessage.GllEvent -> {
            NmeaMessageUi(title = this.getPrettySentenceType(), fields = listOf(
                NmeaFieldUi(name = "TODO", value = null),
                NmeaFieldUi(name = "Checksum", value = this.message.checksum?.toString()),
            ))
        }
        is NmeaMessage.GnsEvent -> {
            NmeaMessageUi(title = this.getPrettySentenceType(), fields = listOf(
                NmeaFieldUi(name = "TODO", value = null),
                NmeaFieldUi(name = "Checksum", value = this.message.checksum?.toString()),
            ))
        }
        is NmeaMessage.GrsEvent -> {
            NmeaMessageUi(title = this.getPrettySentenceType(), fields = listOf(
                NmeaFieldUi(name = "TODO", value = null),
                NmeaFieldUi(name = "Checksum", value = this.message.checksum?.toString()),
            ))
        }
        is NmeaMessage.ProprietaryEvent -> {
            NmeaMessageUi(title = this.getPrettySentenceType(), fields = listOf(
                NmeaFieldUi(name = "Raw", value = this.message.raw),
            ))
        }
        is NmeaMessage.RawEvent -> {
            NmeaMessageUi(title = this.getPrettySentenceType(), fields = listOf(
                NmeaFieldUi(name = "Raw", value = this.message.raw),
            ))
        }
    }
}