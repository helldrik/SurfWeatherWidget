package com.jeldrik.surfweatherwidget.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jeldrik on 17/10/17.
 */

public class MainWeatherInfo {

    @JsonProperty("humidity")
    private String humidity;

    @JsonProperty("pressure")
    private String pressure;

    @JsonProperty("temp_max")
    private String temp_max;

    @JsonProperty("temp_min")
    private String temp_min;

    @JsonProperty("temp")
    private String temp;

    @JsonProperty("humidity")
    public String getHumidity() {
        return humidity;
    }

    @JsonProperty("humidity")
    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    @JsonProperty("pressure")
    public String getPressure() {
        return pressure;
    }

    @JsonProperty("pressure")
    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    @JsonProperty("temp_max")
    public String getTemp_max() {
        return temp_max;
    }

    @JsonProperty("temp_max")
    public void setTemp_max(String temp_max) {
        this.temp_max = temp_max;
    }

    @JsonProperty("temp_min")
    public String getTemp_min() {
        return temp_min;
    }

    @JsonProperty("temp_min")
    public void setTemp_min(String temp_min) {
        this.temp_min = temp_min;
    }

    @JsonProperty("temp")
    public String getTemp() {
        return temp;
    }

    @JsonProperty("temp")
    public void setTemp(String temp) {
        this.temp = temp;
    }
}
