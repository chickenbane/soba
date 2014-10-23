package com.googlejobapp.soba.oba.response;

import java.util.List;

/**
 * Created by joeyt on 10/17/14.
 */
public class StopGroup {

    // id is not globally unique, looks like just unique per response
    private String id;
    private StopGroupName name;
    private List<String> stopIds;
    private List<Polyline> polylines;

    // subGroups - always empty!
//    private List<Object> subGroups;

    /*
     * Many routes only have one element in StopGroupName.names, just use .name.  Also, should assume .type is "destination"
     */
    private static class StopGroupName {
        // names - only one element!
//        private List<String> names;
        private String name;
        // type - always "destination"
//        private String type;
    }

    public String getName() {
        return name.name;
    }
}
