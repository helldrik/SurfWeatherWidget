package com.jeldrik.surfweatherwidget.domain.interactor;

import android.support.annotation.NonNull;

import com.jeldrik.surfweatherwidget.domain.repository.SettingsRepository;

/**
 * @author Madrid Tech Lab on 31/10/2017.
 */

public interface SettingsInteractor {

    SettingsRepository.LocationType getLocationType();

    void setLocationType(@NonNull SettingsRepository.LocationType locationType);

    boolean getLocationTrackingPermitted();

    void setLocationTracking(boolean allowTracking);
}
