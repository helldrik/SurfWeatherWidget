package com.jeldrik.surfweatherwidget.common.Dagger.modules;

import com.jeldrik.surfweatherwidget.domain.interactor.CurrentWeatherInteractor;
import com.jeldrik.surfweatherwidget.presentation.controller.PeriodicUpdateController;
import com.jeldrik.surfweatherwidget.presentation.presenter.MainPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @author Madrid Tech Lab on 21/10/2017.
 */
@Module
public class ActivityModule {

    @Provides
    MainPresenter providesMainPresenter(CurrentWeatherInteractor currentWeatherInteractor, PeriodicUpdateController periodicUpdateController){
        return new MainPresenter(currentWeatherInteractor, periodicUpdateController);
    }
}
