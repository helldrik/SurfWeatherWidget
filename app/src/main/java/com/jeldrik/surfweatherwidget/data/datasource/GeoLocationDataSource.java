package com.jeldrik.surfweatherwidget.data.datasource;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by jeldrik on 28/10/17.
 */

public class GeoLocationDataSource implements LocationListener{

    public interface GeoLocationCallback{
        void onNewGpsData(Map<String, String> locationData);
        void onError(String msg);
    }

    // The minimum distance to change Updates in meters
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10; // 10 meters

    // The minimum time between updates in milliseconds
    private static final long MIN_TIME_BW_UPDATES = 1000 * 30; // 30 sec


    private LocationManager locationManager;
    private Location location;
    private GeoLocationCallback callback;
    Context context;

    @Inject
    public GeoLocationDataSource(@NonNull Context context) {
        this.context = context;
        locationManager = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
    }


    public void getLocation(GeoLocationCallback callback){
        this.callback = callback;
        // getting network status
        boolean isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        if(isNetworkEnabled) {
            try {
                locationManager.requestLocationUpdates(
                        LocationManager.NETWORK_PROVIDER,
                        MIN_TIME_BW_UPDATES,
                        MIN_DISTANCE_CHANGE_FOR_UPDATES, this, context.getMainLooper());
                if (locationManager != null) {
                    location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                }
            } catch (SecurityException e){
                callback.onError(e.toString());
                //TODO: Inform the user that the app has no rights to acces location data
            }
        } else {
            callback.onError("Network not enabled");
        }
    }

    public Map<String, String> getLocationAsString(){
        if (location != null) {
            Map<String, String> locationMap = new HashMap<>();
            locationMap.put("latitude", Double.toString(location.getLatitude()));
            locationMap.put("longitude", Double.toString(location.getLongitude()));
            return locationMap;
        }
        return null;
    }

    @Override
    public void onLocationChanged(Location location) {
        if (callback!=null){
            callback.onNewGpsData(this.getLocationAsString());
        }
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {
        Log.d("SurfWeather", "Status changed +s");
    }

    @Override
    public void onProviderEnabled(String s) {
        Log.d("SurfWeather", "onProviderEnabled "+s);
    }

    @Override
    public void onProviderDisabled(String s) {
        Log.d("SurfWeather", "onProviderDisabled "+s);
    }
}
