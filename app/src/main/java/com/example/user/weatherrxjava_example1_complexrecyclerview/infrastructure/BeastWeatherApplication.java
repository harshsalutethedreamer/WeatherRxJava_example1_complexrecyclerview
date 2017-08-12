package com.example.user.weatherrxjava_example1_complexrecyclerview.infrastructure;

import android.app.Application;

/**
 * Created by user on 8/12/2017.
 */

public class BeastWeatherApplication extends Application {

    public static final String BASE_WEATHER_URI="http://api.openweathermap.org";
    public static final String BASE_WEATHER_API="6ec9dbc4d99908c3cee1cd77acd3f5d";

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
