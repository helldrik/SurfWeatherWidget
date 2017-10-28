package com.jeldrik.surfweatherwidget.domain.interactor;

import android.support.annotation.NonNull;

import com.jeldrik.surfweatherwidget.data.model.CurrentWeather;
import com.jeldrik.surfweatherwidget.domain.executors.PostExecutionThread;
import com.jeldrik.surfweatherwidget.domain.executors.ThreadExecutor;
import com.jeldrik.surfweatherwidget.domain.repository.CurrentWeatherRepository;

/**
 * @author Madrid Tech Lab on 19/10/2017.
 */

public class CurrentWeatherUseCase extends BaseInteractor implements CurrentWeatherInteractor {

    private Callback callback;
    private CurrentWeatherRepository repository;

    public CurrentWeatherUseCase(@NonNull ThreadExecutor threadExecutor, @NonNull PostExecutionThread postExecutionThread, @NonNull CurrentWeatherRepository repository) {
        super(threadExecutor, postExecutionThread);
        this.repository =repository;
    }

    @Override
    public void execute(Callback callback) {
        this.callback = callback;
        execute();
    }

    @Override
    public void run() {
        repository.getCurrentWeather(new CurrentWeatherRepository.CurrentWeatherCallback() {
            @Override
            public void onSuccess(@NonNull final CurrentWeather currentWeather) {
                post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSuccess(currentWeather);
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
