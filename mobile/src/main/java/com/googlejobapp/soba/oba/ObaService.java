package com.googlejobapp.soba.oba;

import com.googlejobapp.soba.oba.response.ArrivalsAndDeparturesForStop;
import com.googlejobapp.soba.oba.response.StopsForLocation;
import com.googlejobapp.soba.oba.response.StopsForRoute;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by joeyt on 10/14/14.
 */
public interface ObaService {
    public static final String ENDPOINT = "http://api.pugetsound.onebusaway.org";

    // includeReferences=false

    @GET("/api/where/stops-for-location.json?version=2")
    StopsForLocation stopsForLocation(@Query("key") String key, @Query("lat") double latitude, @Query("lon") double longitude);

    @GET("/api/where/arrivals-and-departures-for-stop/{stopId}.json?version=2")
    ArrivalsAndDeparturesForStop arrivalsAndDeparturesForStop(@Query("key") String key, @Path("stopId") String stopId);

    @GET("/api/where/stops-for-route/{routeId}.json?version=2")
    StopsForRoute stopsForRoute(@Query("key") String key, @Path("routeId") String stopId);
}
