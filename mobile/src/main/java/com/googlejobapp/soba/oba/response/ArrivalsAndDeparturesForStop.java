package com.googlejobapp.soba.oba.response;

import java.util.List;

/**
 * Created by joeyt on 10/15/14.
 */
public class ArrivalsAndDeparturesForStop extends BaseResponse {
    private ArrivalsAndDeparturesForStopData data;

    private static class ArrivalsAndDeparturesForStopData {
        private References references;
        private ArrivalsAndDeparturesForStopEntry entry;
    }

    private static class ArrivalsAndDeparturesForStopEntry {
        private String stopId;
        private List<String> nearbyStopIds;
        private List<ArrivalAndDeparture> arrivalsAndDepartures;
    }

    public References getReferences() {
        return data.references;
    }

    public List<String> getNearbyStopIds() {
        return data.entry.nearbyStopIds;
    }

    public List<ArrivalAndDeparture> getArrivalsAndDepartures() {
        return data.entry.arrivalsAndDepartures;
    }
}
