package com.googlejobapp.soba.oba.response;

import java.util.List;

/**
 * Created by joeyt on 10/14/14.
 */
public class Stop {
    private String id;
    private double lat;
    private double lon;
    private String name;
    private List<String> routeIds;

    public String getId() {
        return id;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public String getName() {
        return name;
    }

    public List<String> getRouteIds() {
        return routeIds;
    }
}