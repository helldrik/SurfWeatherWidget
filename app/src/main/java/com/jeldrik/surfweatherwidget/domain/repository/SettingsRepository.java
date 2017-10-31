package com.jeldrik.surfweatherwidget.domain.repository;

import android.support.annotation.NonNull;

/**
 * @author Madrid Tech Lab on 31/10/2017.
 */

public interface SettingsRepository {

    public enum LocationType{
        CITY,
        GEO_LOCATION,
        ZIP_CODE,
        UNKNOWN
    }

    LocationType getLocationType();

    void setLocationType(@NonNull LocationType locationType);

    boolean getLocationTrackingPermitted();

    void setLocationTracking(boolean allowTracking);

}
