package com.googlejobapp.soba.oba.response;


import java.util.List;

/**
 * Created by joeyt on 10/17/14.
 */
public class StopsForRoute extends BaseResponse {
    private StopsForRouteData data;

    private static class StopsForRouteData {
        private References references;
        private StopsForRouteEntry entry;
    }

    private static class StopsForRouteEntry {
        private String routeId;
        private List<String> stopIds;

        // TODO: Do I need StopGrouping and Polyline?
        private List<StopGrouping> stopGroupings;
        private List<Polyline> polylines;
    }

    private static class StopGrouping {
        private boolean ordered;
        private String type;  // direction
        private List<StopGroup> stopGroups;
    }

    public References getReferences() {
        return data.references;
    }

}
