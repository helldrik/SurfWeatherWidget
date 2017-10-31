package com.jeldrik.surfweatherwidget.domain.interactor;

import android.support.annotation.NonNull;

import com.jeldrik.surfweatherwidget.domain.repository.SettingsRepository;

import javax.inject.Inject;

/**
 * @author Madrid Tech Lab on 31/10/2017.
 */

public class SettingsUseCase implements SettingsInteractor {

    private SettingsRepository settingsRepository;

    @Inject
    public SettingsUseCase(@NonNull SettingsRepository settingsRepository) {
        this.settingsRepository = settingsRepository;
    }

    @Override
    public SettingsRepository.LocationType getLocationType() {
        return settingsRepository.getLocationType();
    }

    @Override
    public void setLocationType(@NonNull SettingsRepository.LocationType locationType) {
        settingsRepository.setLocationType(locationType);
    }

    @Override
    public boolean getLocationTrackingPermitted() {
        return settingsRepository.getLocationTrackingPermitted();
    }

    @Override
    public void setLocationTracking(boolean allowTracking) {
        settingsRepository.setLocationTracking(allowTracking);
    }
}
