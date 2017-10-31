package com.jeldrik.surfweatherwidget.common.Dagger.components;

import com.jeldrik.surfweatherwidget.common.Dagger.modules.AppModule;
import com.jeldrik.surfweatherwidget.common.Dagger.modules.RepositoryModule;
import com.jeldrik.surfweatherwidget.domain.interactor.CurrentWeatherInteractor;
import com.jeldrik.surfweatherwidget.domain.interactor.GetGeoLocationInteractor;
import com.jeldrik.surfweatherwidget.domain.interactor.SettingsInteractor;
import com.jeldrik.surfweatherwidget.domain.repository.CurrentWeatherRepository;
import com.jeldrik.surfweatherwidget.presentation.presenter.MainPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Madrid Tech Lab on 10/10/2017.
 */
@Singleton
@Component(modules ={AppModule.class, RepositoryModule.class})
public interface ApplicationComponent {

    CurrentWeatherInteractor currentWeatherInteractor();
    GetGeoLocationInteractor getGeoLocationInteractor();
    SettingsInteractor getSettingsInteractor();

    void inject(MainPresenter controller);
}
