package com.jeldrik.surfweatherwidget.presentation.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jeldrik.surfweatherwidget.R;
import com.jeldrik.surfweatherwidget.presentation.Main;
import com.jeldrik.surfweatherwidget.presentation.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainView {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
