package com.jeldrik.surfweatherwidget.common.Dagger.modules;

import android.app.Application;

import com.jeldrik.surfweatherwidget.data.datasource.LocalLocationDataSource;
import com.jeldrik.surfweatherwidget.data.datasource.OpenWeatherNetworkDataSource;
import com.jeldrik.surfweatherwidget.data.repository.CurrentWeatherRepositoryImpl;
import com.jeldrik.surfweatherwidget.domain.repository.CurrentWeatherRepository;
import com.jeldrik.surfweatherwidget.presentation.presenter.MainPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * @author Madrid Tech Lab on 10/10/2017.
 */
@Module
public class AppModule {
    Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    OkHttpClient providesOkHttpClient(){
        return new OkHttpClient();
    }

    @Provides
    @Singleton
    LocalLocationDataSource providesLocalLocationDataSource(){
        return new LocalLocationDataSource();
    }
    @Provides
    @Singleton
    CurrentWeatherRepository providesCurrentWeatherRepository(OpenWeatherNetworkDataSource openWeatherNetworkDataSource){
        return new CurrentWeatherRepositoryImpl(openWeatherNetworkDataSource);
    }

}
