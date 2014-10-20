package com.googlejobapp.soba.oba.response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by joeyt on 10/16/14.
 */
public class References {
    private List<Stop> stops;
    private List<Route> routes;

    public List<Stop> getStops() {
        return stops;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    private transient Map<String, Stop> stopMap;
    private transient Map<String, Route> routeMap;

    public Route getRoute(String id) {
        if (routeMap == null) {
            routeMap = new HashMap<String, Route>();
            for (Route route : routes) {
                routeMap.put(route.getId(), route);
            }
        }
        return routeMap.get(id);
    }

    public Stop getStop(String id) {
        if (stopMap == null) {
            stopMap = new HashMap<String, Stop>();
            for (Stop stop : stops) {
                stopMap.put(stop.getId(), stop);
            }
        }
        return stopMap.get(id);
    }
}
