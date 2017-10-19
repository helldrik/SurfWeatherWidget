package com.jeldrik.surfweatherwidget.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jeldrik on 17/10/17.
 */

class Clouds {
    @JsonProperty("all")
    private String all;

    @JsonProperty("all")
    public String getAll() {
        return all;
    }

    @JsonProperty("all")
    public void setAll(String all) {
        this.all = all;
    }
}
