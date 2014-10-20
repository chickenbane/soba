package com.googlejobapp.soba.oba.response;

/**
 * All fields are optional / may be zero.  Many fields are reporting similar values, I've ordered them in preference.
 *
 * Created by joeyt on 10/16/14.
 */
public class TripStatus {
    // the last known real-time location update from the transit vehicle. Will be zero if we havent heard anything from the vehicle.
    private long lastLocationUpdateTime;

    // seconds, where positive number indicates the trip is running late and negative indicates the trips is running early.
    private int scheduleDeviation;

    private String nextStop;

    // seconds, from the next stop to the current position of the transit vehicle
    private int nextStopTimeOffset;

    private Location position;
    private Location lastKnownLocation;

    // the orientation of the transit vehicle, as an angle in degrees. Here, 0º is east, 90º is north, 180º is west, and 270º is south.
    private double orientation;
    private double lastKnownOrientation;

    public static class Location {
        private double lat;
        private double lon;
    }

    public long getLastLocationUpdateTime() {
        return lastLocationUpdateTime;
    }

    public int getScheduleDeviation() {
        return scheduleDeviation;
    }

    public String getNextStopId() {
        return nextStop;
    }

    public int getNextStopTimeOffset() {
        return nextStopTimeOffset;
    }

    public Location getVehicleLocation() {
        if (position == null) {
            return lastKnownLocation;
        }
        return position;
    }

    public double getVehicleOrientation() {
        if (orientation == 0) {
            return lastKnownOrientation;
        }
        return orientation;
    }

}
