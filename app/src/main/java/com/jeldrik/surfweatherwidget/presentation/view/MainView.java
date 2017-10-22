package com.jeldrik.surfweatherwidget.presentation.view;

/**
 * @author Madrid Tech Lab on 10/10/2017.
 */

public interface MainView {
    void setCurrentTemp(String s);

    void setMinTemp(String s);

    void setMaxTemp(String s);

    void setCondition(String condition);

    void setWind(String wind);

    void setHumidity(String humidity);

    void setSunrise(String s);

    void setSunset(String s);
}
