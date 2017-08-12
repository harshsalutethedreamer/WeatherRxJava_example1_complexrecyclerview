package com.example.user.weatherrxjava_example1_complexrecyclerview.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.weatherrxjava_example1_complexrecyclerview.R;
import com.example.user.weatherrxjava_example1_complexrecyclerview.entities.WeatherData;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 8/12/2017.
 */

public class WeatherViewHolder extends RecyclerView.ViewHolder{

    @BindView(R.id.list_weather_item_date)
    TextView weatherDate;

    @BindView(R.id.list_weather_item_weatherDescription)
    TextView weatherDescription;

    @BindView(R.id.list_weather_item_max)
    TextView weatherTemperaturMax;

    @BindView(R.id.list_weather_item_min)
    TextView weatherTemperatureMin;

    @BindView(R.id.list_weather_item_ImageView)
    ImageView weatherImage;

    public WeatherViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void populate(WeatherData weatherData, int position){
        itemView.setTag(weatherData);
        String date;

        if(position==0){
            date="today";
        }else if(position==1){
            date="tomorrow";
        }else{
            date=weatherData.getWeatherDate();
        }

        weatherDate.setText(date);
        weatherDescription.setText(weatherData.getWeatherDetailed());
        weatherTemperatureMin.setText(roundWeather(weatherData.getTemperatureMin()));
        weatherTemperaturMax.setText(roundWeather(weatherData.getTemperatureMin()));
        weatherImage.setImageResource(R.mipmap.ic_launcher);
    }

    private String roundWeather(double tempeature){
        double roundWeather=Math.round(tempeature);
        return Double.toString(roundWeather);
    }
}
