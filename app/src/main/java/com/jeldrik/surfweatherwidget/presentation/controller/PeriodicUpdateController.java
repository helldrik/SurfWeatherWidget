package com.jeldrik.surfweatherwidget.presentation.controller;

import android.support.annotation.NonNull;

import com.jeldrik.surfweatherwidget.domain.interactor.GetGeoLocationInteractor;
import com.jeldrik.surfweatherwidget.domain.interactor.SettingsInteractor;
import com.jeldrik.surfweatherwidget.domain.repository.SettingsRepository;
import com.jeldrik.surfweatherwidget.presentation.presenter.MainPresenter;

import java.util.Map;

import javax.inject.Inject;

/**
 * Created by jeldrik on 29/10/17.
 */

public class PeriodicUpdateController {

    private GetGeoLocationInteractor geoLocationInteractor;
    private SettingsInteractor settingsInteractor;

    private Map<String, String> geoLocation;
    private MainPresenter mainPresenter;

    @Inject
    public PeriodicUpdateController(@NonNull GetGeoLocationInteractor geoLocationInteractor, @NonNull SettingsInteractor settingsInteractor) {
        this.geoLocationInteractor = geoLocationInteractor;
        this.settingsInteractor = settingsInteractor;
        this.onCreate();
    }

    public void onCreate(){
            if (geoLocationInteractor != null) {
                final android.os.Handler handler = new android.os.Handler();
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        if(settingsInteractor.getLocationType().equals(SettingsRepository.LocationType.GEO_LOCATION)) {
                            loadGeoLocationData();
                        }
                        if(mainPresenter != null) {
                            mainPresenter.loadData();
                        }
                        handler.postDelayed(this, 600000);
                    }
                };
                handler.post(runnable);
            }

        }

    private void loadGeoLocationData() {
        geoLocationInteractor.execute(new GetGeoLocationInteractor.Callback() {

            @Override
            public void onSucess(Map<String, String> geoLocation){
                PeriodicUpdateController.this.geoLocation = geoLocation;
            }

            @Override
            public void onError() {

            }
        });
    }

    public void setMainPresenter(MainPresenter mainPresenter) {
        this.mainPresenter = mainPresenter;
    }
}
