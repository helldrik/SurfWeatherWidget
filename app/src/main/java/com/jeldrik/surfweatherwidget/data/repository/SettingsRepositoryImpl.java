package com.jeldrik.surfweatherwidget.data.repository;

import android.support.annotation.NonNull;

import com.jeldrik.surfweatherwidget.data.datasource.SettingsDataSource;
import com.jeldrik.surfweatherwidget.domain.repository.SettingsRepository;

import javax.inject.Inject;

/**
 * @author Madrid Tech Lab on 31/10/2017.
 */

public class SettingsRepositoryImpl implements SettingsRepository {

    private SettingsDataSource settingsDataSource;

    @Inject
    public SettingsRepositoryImpl(SettingsDataSource settingsDataSource) {
        this.settingsDataSource = settingsDataSource;
    }

    @Override
    public LocationType getLocationType() {
        return settingsDataSource.getLocationType();
    }

    @Override
    public void setLocationType(@NonNull LocationType locationType) {
        settingsDataSource.setLocationType(locationType);
    }

    @Override
    public boolean getLocationTrackingPermitted() {
        return settingsDataSource.getLocationTrackingPermitted();
    }

    @Override
    public void setLocationTracking(boolean allowTracking) {
        settingsDataSource.setLocationTracking(allowTracking);
    }
}
