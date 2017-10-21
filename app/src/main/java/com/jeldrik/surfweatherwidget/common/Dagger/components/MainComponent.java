package com.jeldrik.surfweatherwidget.common.Dagger.components;

import com.jeldrik.surfweatherwidget.common.Dagger.ActivityScope;
import com.jeldrik.surfweatherwidget.common.Dagger.modules.ActivityModule;
import com.jeldrik.surfweatherwidget.presentation.presenter.MainPresenter;
import com.jeldrik.surfweatherwidget.presentation.view.MainActivity;

import dagger.Component;

/**
 * @author Madrid Tech Lab on 21/10/2017.
 */
@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class})
public interface MainComponent {

    void inject(MainActivity activity);
}
