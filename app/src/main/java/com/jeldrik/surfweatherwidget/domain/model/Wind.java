package com.jeldrik.surfweatherwidget.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jeldrik on 17/10/17.
 */

class Wind {
    @JsonProperty("speed")
    private String speed;

    @JsonProperty("deg")
    private String deg;

    @JsonProperty("speed")
    public String getSpeed() {
        return speed;
    }

    @JsonProperty("speed")
    public void setSpeed(String speed) {
        this.speed = speed;
    }

    @JsonProperty("deg")
    public String getDeg() {
        return deg;
    }

    @JsonProperty("deg")
    public void setDeg(String deg) {
        this.deg = deg;
    }
}
