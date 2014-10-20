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
        private List<StopGrouping> stopGroupings;
    }


    public References getReferences() {
        return data.references;
    }
}
