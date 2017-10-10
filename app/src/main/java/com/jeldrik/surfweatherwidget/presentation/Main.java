package com.jeldrik.surfweatherwidget.presentation;

import android.app.Application;

import com.jeldrik.surfweatherwidget.common.Dagger.components.ApplicationComponent;
import com.jeldrik.surfweatherwidget.common.Dagger.components.DaggerApplicationComponent;
import com.jeldrik.surfweatherwidget.common.Dagger.modules.AppModule;

/**
 * @author Madrid Tech Lab on 10/10/2017.
 */

public class Main extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .appModule(new AppModule(this))
                .build();

    }
}
