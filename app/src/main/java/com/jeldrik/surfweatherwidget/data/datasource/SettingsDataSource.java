package com.jeldrik.surfweatherwidget.data.datasource;

import javax.inject.Inject;

/**
 * Created by jeldrik on 28/10/17.
 *
 * class to get/set the apps settings like type of location
 */

public class SettingsDataSource {

    private SharedPrefsLocalDataSource sharedPrefsLocalDataSource;

    public enum LocationType{
        CITY,
        GEO_LOCATION,
        ZIP_CODE,
        UNKNOWN
    }

    @Inject
    public SettingsDataSource(SharedPrefsLocalDataSource sharedPrefsLocalDataSource) {
        this.sharedPrefsLocalDataSource = sharedPrefsLocalDataSource;
    }

    public LocationType getLocationType(){
        try{
            return LocationType.valueOf(sharedPrefsLocalDataSource.getString("locationType"));
        } catch (IllegalArgumentException e) {
            return LocationType.UNKNOWN;
        }
    }

    public void setLocationType(LocationType locationType){
        sharedPrefsLocalDataSource.save("locationType", locationType.toString());
    }

    public boolean getLocationTrackingPermitted(){
        return sharedPrefsLocalDataSource.getBoolean("locationTracking");
    }

    public void setLocationTracking(boolean allowTracking){
        sharedPrefsLocalDataSource.save("locationTracking", allowTracking);
    }
}
