package com.jeldrik.surfweatherwidget.common.Dagger.modules;

import android.app.Application;

import com.jeldrik.surfweatherwidget.presentation.presenter.MainPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

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

}
