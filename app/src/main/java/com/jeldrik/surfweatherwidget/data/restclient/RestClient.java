package com.jeldrik.surfweatherwidget.data.restclient;

import android.support.annotation.NonNull;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by jeldrik on 17/10/17.
 */

final public class RestClient {

    public static RestApi getRestApiClient(@NonNull String baseUrl, OkHttpClient okHttpClient){
        Retrofit retrofit = createClient(baseUrl, okHttpClient);
        return retrofit.create(RestApi.class);
    }

    private static Retrofit createClient(@NonNull String baseUrl, @NonNull OkHttpClient client) {
        ObjectMapper mapper = getParser();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(JacksonConverterFactory.create(mapper))
                .client(client)
                .build();
        return retrofit;
    }

    @NonNull
    private static ObjectMapper getParser() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        mapper.configure(DeserializationFeature.READ_ENUMS_USING_TO_STRING, true);
        mapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);
        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        return mapper;
    }
}
