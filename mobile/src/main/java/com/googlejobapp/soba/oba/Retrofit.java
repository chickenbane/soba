package com.googlejobapp.soba.oba;

import com.googlejobapp.soba.oba.response.ArrivalAndDeparture;
import com.googlejobapp.soba.oba.response.ArrivalsAndDeparturesForStop;
import com.googlejobapp.soba.oba.response.BaseResponse;
import com.googlejobapp.soba.oba.response.References;
import com.googlejobapp.soba.oba.response.Route;
import com.googlejobapp.soba.oba.response.Stop;
import com.googlejobapp.soba.oba.response.StopsForLocation;

import retrofit.RestAdapter;

/**
 * Created by joeyt on 10/14/14.
 */
public class Retrofit {

    private static void printStopsForLocation(StopsForLocation response) {
        System.out.println("STOPS FOR LOCATION " + response.getBaseResponseString());
        for (Stop stop : response.getStops()) {
            printStop(response, stop);
        }
    }

    private static void printStop(BaseResponse response, Stop stop) {
        System.out.println("stop] " + stop.getName() + " (" + stop.getLat() + ", " + stop.getLon() + ")");
        for (String id : stop.getRouteIds()) {
            Route r = response.getReferences().getRoute(id);
            System.out.println("    " + r.getShortName() + " " + r.getDescription() + " (routeId=" + id + ")");
        }
    }

    private static void printArrivalsAndDeparturesForStop(ArrivalsAndDeparturesForStop response) {
        System.out.println("ARRIVALS AND DEPARTURES FOR STOP " + response.getBaseResponseString());
        System.out.println("Nearby Stops:");
        References references = response.getReferences();
        long now = response.getCurrentTime();
        for (String id : response.getNearbyStopIds()) {
            Stop s = references.getStop(id);
            printStop(response, s);
        }
        System.out.println("Arrivals and Departures:");
        for (ArrivalAndDeparture aad : response.getArrivalsAndDepartures()) {
            Route r = references.getRoute(aad.getRouteId());
            long minutesAway = (aad.getEta() - now)/1000/60;
            System.out.println(r.getShortName() + " " + r.getDescription() + " minutesAway=" + minutesAway + " stopsAway=" + aad.getNumberOfStopsAway());
        }
    }

    public static void main(String[] args) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(ObaService.ENDPOINT)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        ObaService service = restAdapter.create(ObaService.class);

        // http://api.pugetsound.onebusaway.org/api/where/stops-for-location.json?key=TEST&lat=47.623648&lon=-122.321216
        printStopsForLocation(service.stopsForLocation("TEST", 47.623648, -122.321216));

        printArrivalsAndDeparturesForStop(service.arrivalsAndDeparturesForStop("TEST", "1_11011"));

        // http://api.pugetsound.onebusaway.org/api/where/stops-for-route/1_100289.json?key=TEST&version=2
//        StopsForRoute stopsForRoute = service.stopsForRoute("TEST", "1_100289");
    }
}
