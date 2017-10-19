package com.jeldrik.surfweatherwidget.common.Dagger.modules;

import android.app.Application;

import com.jeldrik.surfweatherwidget.data.datasource.LocalLocationDataSource;
import com.jeldrik.surfweatherwidget.data.datasource.OpenWeatherNetworkDataSource;
import com.jeldrik.surfweatherwidget.data.repository.CurrentWeatherRepositoryImpl;
import com.jeldrik.surfweatherwidget.domain.executors.PostExecutionThread;
import com.jeldrik.surfweatherwidget.domain.executors.ThreadExecutor;
import com.jeldrik.surfweatherwidget.domain.interactor.CurrentWeatherInteractor;
import com.jeldrik.surfweatherwidget.domain.interactor.CurrentWeatherUseCase;
import com.jeldrik.surfweatherwidget.domain.repository.CurrentWeatherRepository;
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
    LocalLocationDataSource providesLocalLocationDataSource(){
        return new LocalLocationDataSource();
    }
    @Provides
    @Singleton
    CurrentWeatherInteractor providesCurrentWeatherInteractor(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, CurrentWeatherRepository currentWeatherRepository){
        return new CurrentWeatherUseCase(threadExecutor, postExecutionThread, currentWeatherRepository );
    }
}
