package com.jeldrik.surfweatherwidget.data.datasource;

import android.support.annotation.NonNull;

import com.jeldrik.surfweatherwidget.domain.repository.SettingsRepository;
import javax.inject.Inject;

/**
 * Created by jeldrik on 28/10/17.
 *
 * class to get/set the apps settings like type of location
 */

public class SettingsDataSource {

    private SharedPrefsLocalDataSource sharedPrefsLocalDataSource;



    @Inject
    public SettingsDataSource(@NonNull SharedPrefsLocalDataSource sharedPrefsLocalDataSource) {
        this.sharedPrefsLocalDataSource = sharedPrefsLocalDataSource;
        //default locationType
        setLocationType(SettingsRepository.LocationType.GEO_LOCATION);
    }

    public SettingsRepository.LocationType getLocationType(){
        try{
            return SettingsRepository.LocationType.valueOf(sharedPrefsLocalDataSource.getString("locationType"));
        } catch (IllegalArgumentException e) {
            return SettingsRepository.LocationType.UNKNOWN;
        }
    }

    public void setLocationType(SettingsRepository.LocationType locationType){
        sharedPrefsLocalDataSource.save("locationType", locationType.toString());
    }

    public boolean getLocationTrackingPermitted(){
        return sharedPrefsLocalDataSource.getBoolean("locationTracking");
    }

    public void setLocationTracking(boolean allowTracking){
        sharedPrefsLocalDataSource.save("locationTracking", allowTracking);
    }
}
