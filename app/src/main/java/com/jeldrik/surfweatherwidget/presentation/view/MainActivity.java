package com.jeldrik.surfweatherwidget.presentation.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.jeldrik.surfweatherwidget.R;
import com.jeldrik.surfweatherwidget.common.Dagger.components.ApplicationComponent;
import com.jeldrik.surfweatherwidget.common.Dagger.components.DaggerMainComponent;
import com.jeldrik.surfweatherwidget.common.Dagger.components.MainComponent;
import com.jeldrik.surfweatherwidget.common.Dagger.modules.ActivityModule;
import com.jeldrik.surfweatherwidget.presentation.Main;
import com.jeldrik.surfweatherwidget.presentation.presenter.MainPresenter;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainView {

    @Inject
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initInjection();
    }

    /**
     * Initializes the dependency injection for this class.
     */
    private  void initInjection() {
        Main main = (Main)getApplication();
        MainComponent mainComponent = DaggerMainComponent.builder()
                .applicationComponent(main.getApplicationComponent())
                .activityModule(new ActivityModule())
                .build();
        mainComponent.inject(this);
        presenter.setView(this);
        presenter.create();
    }

    @Override
    public void setCurrentTemp(String s) {
        TextView currentTemp = (TextView)findViewById(R.id.temp);
        currentTemp.setText(s);
    }

    @Override
    public void setMinTemp(String s) {

    }

    @Override
    public void setMaxTemp(String s) {

    }
}
