package com.jeldrik.surfweatherwidget.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jeldrik on 17/10/17.
 */

class Coord {

    @JsonProperty("lon")
    private String lon;

    @JsonProperty("lat")
    private String lat;

    @JsonProperty("lon")
    public String getLon() {
        return lon;
    }

    @JsonProperty("lon")
    public void setLon(String lon) {
        this.lon = lon;
    }

    @JsonProperty("lat")
    public String getLat() {
        return lat;
    }

    @JsonProperty("lat")
    public void setLat(String lat) {
        this.lat = lat;
    }
}
