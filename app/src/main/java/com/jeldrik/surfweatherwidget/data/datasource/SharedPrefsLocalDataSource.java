package com.jeldrik.surfweatherwidget.data.datasource;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by jeldrik on 28/10/17.
 */

public class SharedPrefsLocalDataSource {


    private SharedPreferences sharedPreferences;
    private static final String NAME = "SurfWeatherWidget";


    public SharedPrefsLocalDataSource(Context context) {
        sharedPreferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
    }

    public void save(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public void save(String key, int value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public void save(String key, float value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat(key, value);
        editor.commit();
    }

    public void save(String key, long value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(key, value);
        editor.commit();
    }

    public String getString(String key) {
        return sharedPreferences.getString(key, "");
    }

    public int getInt(String key) {
        return sharedPreferences.getInt(key, 0);
    }

    public float getFloat(String key) {
        return sharedPreferences.getFloat(key, 0);
    }

    public long getLong(String key) {
        return sharedPreferences.getLong(key, 0);
    }
}
