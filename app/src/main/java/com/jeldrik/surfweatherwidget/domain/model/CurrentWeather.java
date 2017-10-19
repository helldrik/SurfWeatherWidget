package com.jeldrik.surfweatherwidget.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jeldrik on 17/10/17.
 */

public class CurrentWeather {

    private final String COORDINATES_KEY = "coord";
    private final String SYS_KEY = "sys";
    private final String WEATHER_KEY = "weather";
    private final String BASE_KEY = "base";
    private final String Main_WEATHER_KEY = "main";
    private final String WIND_KEY = "wind";
    private final String CLOUD_KEY = "clouds";
    private final String DT_KEY = "dt";
    private final String ID_KEY = "id";
    private final String NAME_KEY = "name";
    private final String COD_KEY = "cod";

    @JsonProperty(ID_KEY)
    private String id;

    @JsonProperty(DT_KEY)
    private String dt;

    @JsonProperty(CLOUD_KEY)
    private Clouds clouds;

    @JsonProperty(COORDINATES_KEY)
    private Coord coord;

    @JsonProperty(WIND_KEY)
    private Wind wind;

    @JsonProperty(COD_KEY)
    private String cod;

    @JsonProperty(SYS_KEY)
    private Sys sys;

    @JsonProperty(NAME_KEY)
    private String name;

    @JsonProperty(BASE_KEY)
    private String base;

    @JsonProperty(WEATHER_KEY)
    private Weather[] weather;

    @JsonProperty(Main_WEATHER_KEY)
    private MainWeatherInfo main;

    @JsonProperty(ID_KEY)
    public String getId() {
        return id;
    }

    @JsonProperty(ID_KEY)
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty(DT_KEY)
    public String getDt() {
        return dt;
    }

    @JsonProperty(DT_KEY)
    public void setDt(String dt) {
        this.dt = dt;
    }

    @JsonProperty(CLOUD_KEY)
    public Clouds getClouds() {
        return clouds;
    }

    @JsonProperty(CLOUD_KEY)
    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    @JsonProperty(COORDINATES_KEY)
    public Coord getCoord() {
        return coord;
    }

    @JsonProperty(COORDINATES_KEY)
    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    @JsonProperty(WIND_KEY)
    public Wind getWind() {
        return wind;
    }

    @JsonProperty(WIND_KEY)
    public void setWind(Wind wind) {
        this.wind = wind;
    }

    @JsonProperty(COD_KEY)
    public String getCod() {
        return cod;
    }

    @JsonProperty(COD_KEY)
    public void setCod(String cod) {
        this.cod = cod;
    }

    @JsonProperty(SYS_KEY)
    public Sys getSys() {
        return sys;
    }

    @JsonProperty(SYS_KEY)
    public void setSys(Sys sys) {
        this.sys = sys;
    }

    @JsonProperty(NAME_KEY)
    public String getName() {
        return name;
    }

    @JsonProperty(NAME_KEY)
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty(BASE_KEY)
    public String getBase() {
        return base;
    }

    @JsonProperty(BASE_KEY)
    public void setBase(String base) {
        this.base = base;
    }

    @JsonProperty(WEATHER_KEY)
    public Weather[] getWeather() {
        return weather;
    }

    @JsonProperty(WEATHER_KEY)
    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }

    @JsonProperty(Main_WEATHER_KEY)
    public MainWeatherInfo getMain() {
        return main;
    }

    @JsonProperty(Main_WEATHER_KEY)
    public void setMain(MainWeatherInfo main) {
        this.main = main;
    }

}
