package com.jeldrik.surfweatherwidget.presentation.view;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
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

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView {

    @Inject
    MainPresenter presenter;

    @BindView(R.id.temp)
    TextView currentTemp;
    @BindView(R.id.min_temp)
    TextView minTemp;
    @BindView(R.id.max_temp)
    TextView maxTemp;
    @BindView(R.id.condition)
    TextView condition;
    @BindView(R.id.wind)
    TextView wind;
    @BindView(R.id.humidity)
    TextView humidity;
    @BindView(R.id.sunrise)
    TextView sunrise;
    @BindView(R.id.sunset)
    TextView sunset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
        ButterKnife.bind(this);
        initInjection();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {
                    // permission denied, boo!

                }
                return;
            }
            // other 'case' lines to check for other
            // permissions this app might request
        }
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
        currentTemp.setText(String.format(getString(R.string.current_temp),s));
    }

    @Override
    public void setMinTemp(String s) {
        minTemp.setText(String.format(getString(R.string.min_temp),s));
    }

    @Override
    public void setMaxTemp(String s) {
        maxTemp.setText(String.format(getString(R.string.max_temp),s));
    }

    @Override
    public void setCondition(String s) {
        condition.setText(s);
    }

    @Override
    public void setWind(String s) {
        wind.setText(String.format(getString(R.string.wind_value), s));
    }

    @Override
    public void setHumidity(String s) {
        humidity.setText(String.format(getString(R.string.humidity_value), s));
    }

    @Override
    public void setSunrise(String s) {
        sunrise.setText(String.format(getString(R.string.sunrise), s));
    }

    @Override
    public void setSunset(String s) {
        sunset.setText(String.format(getString(R.string.sunset), s));
    }
}
