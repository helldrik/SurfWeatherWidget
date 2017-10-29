package com.jeldrik.surfweatherwidget.presentation.controller;

import android.support.annotation.NonNull;

import com.jeldrik.surfweatherwidget.domain.interactor.GetGeoLocationInteractor;
import com.jeldrik.surfweatherwidget.presentation.presenter.MainPresenter;

import java.util.Map;

import javax.inject.Inject;

/**
 * Created by jeldrik on 29/10/17.
 */

public class PeriodicUpdateController {

    private GetGeoLocationInteractor geoLocationInteractor;
    private Map<String, String> geoLocation;
    private MainPresenter mainPresenter;

    @Inject
    public PeriodicUpdateController(@NonNull GetGeoLocationInteractor geoLocationInteractor) {
        this.geoLocationInteractor = geoLocationInteractor;
    }

    public void onCreate(){
            if (geoLocationInteractor != null) {
                final android.os.Handler handler = new android.os.Handler();
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        loadData();
                        mainPresenter.loadData();
                        handler.postDelayed(this, 600000);
                    }
                };
                handler.post(runnable);
            }

        }

    private void loadData() {
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
        this.onCreate();
    }
}
