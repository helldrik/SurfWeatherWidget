package com.jeldrik.surfweatherwidget.common.Dagger.modules;

import android.app.Application;
import android.content.Context;

import com.jeldrik.surfweatherwidget.data.datasource.LocalLocationDataSource;
import com.jeldrik.surfweatherwidget.data.datasource.OpenWeatherCachedDataSource;
import com.jeldrik.surfweatherwidget.data.datasource.OpenWeatherNetworkDataSource;
import com.jeldrik.surfweatherwidget.data.datasource.SharedPrefsLocalDataSource;
import com.jeldrik.surfweatherwidget.data.repository.CurrentWeatherRepositoryImpl;
import com.jeldrik.surfweatherwidget.domain.executors.PostExecutionThread;
import com.jeldrik.surfweatherwidget.domain.executors.ThreadExecutor;
import com.jeldrik.surfweatherwidget.domain.interactor.CurrentWeatherInteractor;
import com.jeldrik.surfweatherwidget.domain.interactor.CurrentWeatherUseCase;
import com.jeldrik.surfweatherwidget.domain.interactor.GetGeoLocationInteractor;
import com.jeldrik.surfweatherwidget.domain.interactor.GetGeoLocationUseCase;
import com.jeldrik.surfweatherwidget.domain.repository.CurrentWeatherRepository;
import com.jeldrik.surfweatherwidget.domain.repository.GeoLocationRepository;
import com.jeldrik.surfweatherwidget.presentation.controller.PeriodicUpdateController;
import com.jeldrik.surfweatherwidget.presentation.executor.BackgroundExecutor;
import com.jeldrik.surfweatherwidget.presentation.executor.UiThread;
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
    Context providesContext(){
        return mApplication.getApplicationContext();
    }

    @Provides
    @Singleton
    SharedPrefsLocalDataSource providesSharedPrefsLocalDataSource() {
        return new SharedPrefsLocalDataSource(mApplication);
    }

    @Provides
    @Singleton
    ThreadExecutor providesThreadExecutor(BackgroundExecutor backgroundExecutor) {
        return backgroundExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providesPostExecutionThread(UiThread uiThread) {
        return uiThread;
    }


    @Provides
    @Singleton
    OkHttpClient providesOkHttpClient(){
        return new OkHttpClient();
    }

    @Provides
    @Singleton
    LocalLocationDataSource providesLocalLocationDataSource(SharedPrefsLocalDataSource sharedPrefsLocalDataSource){
        return new LocalLocationDataSource(sharedPrefsLocalDataSource);
    }
    @Provides
    @Singleton
    OpenWeatherCachedDataSource openWeatherCachedDataSource(SharedPrefsLocalDataSource sharedPrefsLocalDataSource){
        return new OpenWeatherCachedDataSource(sharedPrefsLocalDataSource);
    }
    @Provides
    @Singleton
    CurrentWeatherInteractor providesCurrentWeatherInteractor(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, CurrentWeatherRepository currentWeatherRepository){
        return new CurrentWeatherUseCase(threadExecutor, postExecutionThread, currentWeatherRepository );
    }

    @Provides
    @Singleton
    GetGeoLocationInteractor providesGeoLocationInteractor(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, GeoLocationRepository geoLocationRepository){
        return new GetGeoLocationUseCase(threadExecutor, postExecutionThread, geoLocationRepository);
    }

    @Provides
    @Singleton
    PeriodicUpdateController providesPeriodicUpdateController(GetGeoLocationInteractor getGeoLocationInteractor){
        return new PeriodicUpdateController(getGeoLocationInteractor);
    }
}
