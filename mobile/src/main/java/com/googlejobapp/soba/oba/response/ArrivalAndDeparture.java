package com.googlejobapp.soba.oba.response;

/**
 * Created by joeyt on 10/15/14.
 */
public class ArrivalAndDeparture {
    private String routeId;
    private String stopId;
    private long scheduledArrivalTime;
    private long predictedArrivalTime;
    private double distanceFromStop;
    private int numberOfStopsAway;
    private TripStatus tripStatus;

    public String getRouteId() {
        return routeId;
    }

    public String getStopId() {
        return stopId;
    }

    // meters
    public double getDistanceFromStop() {
        return distanceFromStop;
    }

    public int getNumberOfStopsAway() {
        return numberOfStopsAway;
    }

    public TripStatus getTripStatus() {
        return tripStatus;
    }

    // ms from epcoch
    public long getEta() {
        if (predictedArrivalTime == 0) {
            return scheduledArrivalTime;
        }
        return predictedArrivalTime;
    }
}
