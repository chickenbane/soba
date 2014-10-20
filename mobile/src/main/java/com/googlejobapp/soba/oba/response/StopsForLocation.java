package com.googlejobapp.soba.oba.response;

import java.util.List;

/**
 * Created by joeyt on 10/14/14.
 */
public class StopsForLocation extends BaseResponse {
    private StopsForLocationData data;

    private static class StopsForLocationData {
        private References references;
        private List<Stop> list;
    }

    public List<Stop> getStops() {
        return data.list;
    }

    public References getReferences() {
        return data.references;
    }
}
