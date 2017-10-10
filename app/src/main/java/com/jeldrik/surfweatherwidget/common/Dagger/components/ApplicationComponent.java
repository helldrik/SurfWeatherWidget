package com.jeldrik.surfweatherwidget.common.Dagger.components;

import com.jeldrik.surfweatherwidget.common.Dagger.modules.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Madrid Tech Lab on 10/10/2017.
 */
@Singleton
@Component(modules ={AppModule.class})
public interface ApplicationComponent {
}
