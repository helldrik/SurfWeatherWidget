package com.jeldrik.surfweatherwidget.presentation.presenter;

import com.jeldrik.surfweatherwidget.common.Dagger.components.ApplicationComponent;
import com.jeldrik.surfweatherwidget.presentation.Main;

import javax.inject.Inject;

/**
 * @author Madrid Tech Lab on 10/10/2017.
 */

public class MainPresenter {

    @Inject
    public MainPresenter() {
    }

    /**
     * Initializes the dependency injection for this class.
     *
     */
    public void initInjection(ApplicationComponent applicationComponent) {
        applicationComponent.inject(this);
    }
}
