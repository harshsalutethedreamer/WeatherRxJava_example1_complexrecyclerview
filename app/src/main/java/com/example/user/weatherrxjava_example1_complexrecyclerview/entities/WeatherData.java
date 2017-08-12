package com.example.user.weatherrxjava_example1_complexrecyclerview.entities;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by user on 8/12/2017.
 */

public class WeatherData implements Parcelable{
    private double temperatureMax;
    private double temperatureMin,pressure,humidity;
    private String weatherBasic,weatherDetailed,weatherDate;

    public WeatherData(double temperatureMax, double temperatureMin, double pressure, double humidity, String weatherBasic, String weatherDetailed, String weatherDate) {
        this.temperatureMax = temperatureMax;
        this.temperatureMin = temperatureMin;
        this.pressure = pressure;
        this.humidity = humidity;
        this.weatherBasic = weatherBasic;
        this.weatherDetailed = weatherDetailed;
        this.weatherDate = weatherDate;
    }

    protected WeatherData(Parcel in) {
        temperatureMax = in.readDouble();
        temperatureMin = in.readDouble();
        pressure = in.readDouble();
        humidity = in.readDouble();
        weatherBasic = in.readString();
        weatherDetailed = in.readString();
        weatherDate = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(temperatureMax);
        dest.writeDouble(temperatureMin);
        dest.writeDouble(pressure);
        dest.writeDouble(humidity);
        dest.writeString(weatherBasic);
        dest.writeString(weatherDetailed);
        dest.writeString(weatherDate);
    }

    public static final Creator<WeatherData> CREATOR = new Creator<WeatherData>() {
        @Override
        public WeatherData createFromParcel(Parcel in) {
            return new WeatherData(in);
        }

        @Override
        public WeatherData[] newArray(int size) {
            return new WeatherData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public double getTemperatureMax() {
        return temperatureMax;
    }

    public double getTemperatureMin() {
        return temperatureMin;
    }

    public double getPressure() {
        return pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public String getWeatherBasic() {
        return weatherBasic;
    }

    public String getWeatherDetailed() {
        return weatherDetailed;
    }

    public String getWeatherDate() {
        return weatherDate;
    }
}
