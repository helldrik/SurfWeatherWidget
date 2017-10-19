package com.jeldrik.surfweatherwidget.data.datasource;

import android.support.annotation.NonNull;

import com.jeldrik.surfweatherwidget.data.model.CurrentWeather;
import com.jeldrik.surfweatherwidget.data.restclient.RestApi;
import com.jeldrik.surfweatherwidget.data.restclient.RestClient;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;

/**
 * @author Madrid Tech Lab on 19/10/2017.
 */

public class OpenWeatherNetworkDataSource {

    private OkHttpClient okHttpClient;
    private LocalLocationDataSource localLocationDataSource;

    private final String baseUrl = "api.openweathermap.org/data/2.5/";

    @Inject
    public OpenWeatherNetworkDataSource(@NonNull OkHttpClient okHttpClient, @NonNull LocalLocationDataSource localLocationDataSource) {
        this.okHttpClient = okHttpClient;
        this.localLocationDataSource = localLocationDataSource;
    }

    public void getCurrentWeather() {
        RestApi api = RestClient.getRestApiClient(baseUrl, okHttpClient);
        Call<CurrentWeather> call = api.loadCurrentWeatherByGeoLocation(localLocationDataSource.getLatitude(), localLocationDataSource.getLongitude());
        try {
            if (call == null) {
                //callback.onError(new DomainException());
                return;
            }
            Response response = call.execute();

            if (response == null) {
                //callback.onError(new DomainException());
                return;
            }
            if (!response.isSuccessful()) {
                //callback.onError(new DomainException());
                return;
            }
            //cllback.onSuccess(response.body();)

        } catch (IOException e) {
            //callback.onError(new DomainException());
        }

    }
}
