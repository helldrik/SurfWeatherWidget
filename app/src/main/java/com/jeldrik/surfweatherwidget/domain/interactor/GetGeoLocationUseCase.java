package com.jeldrik.surfweatherwidget.domain.interactor;

import android.support.annotation.NonNull;

import com.jeldrik.surfweatherwidget.domain.executors.PostExecutionThread;
import com.jeldrik.surfweatherwidget.domain.executors.ThreadExecutor;
import com.jeldrik.surfweatherwidget.domain.repository.GeoLocationRepository;

import java.util.Map;

import javax.inject.Inject;

/**
 * Created by jeldrik on 29/10/17.
 */

public class GetGeoLocationUseCase extends BaseInteractor implements GetGeoLocationInteractor {

    GeoLocationRepository repository;
    private Callback callback;

    @Inject
    public GetGeoLocationUseCase(@NonNull ThreadExecutor threadExecutor, @NonNull PostExecutionThread postExecutionThread, @NonNull GeoLocationRepository repository) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    @Override
    public void execute(Callback callback) {
        this.callback = callback;
        execute();
    }

    @Override
    public void run() {
        repository.getGeoLocation(new GeoLocationRepository.Callback() {
            @Override
            public void onSucess(final Map<String, String> geoLocation) {
                post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSucess(geoLocation);
                    }
                });
            }

            @Override
            public void onError() {
                    post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onError();
                        }
                    });
            }
        });
    }
}
