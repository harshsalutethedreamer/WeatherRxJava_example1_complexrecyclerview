package com.example.user.weatherrxjava_example1_complexrecyclerview.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.weatherrxjava_example1_complexrecyclerview.R;
import com.example.user.weatherrxjava_example1_complexrecyclerview.entities.WeatherData;
import com.example.user.weatherrxjava_example1_complexrecyclerview.views.WeatherAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 8/12/2017.
 */

public class ForecastFragment extends Fragment implements WeatherAdapter.WeatherListener{

    @BindView(R.id.fragment_forecast_recyclerView)
    RecyclerView recyclerView;

    public static ForecastFragment newInstance() {
        ForecastFragment fragment = new ForecastFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_forecast,container,false);
        ButterKnife.bind(this,rootView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        WeatherAdapter adapter=new WeatherAdapter(getActivity(),this);
        adapter.setWeatherDataList(getWeather());
        recyclerView.setAdapter(adapter);
        return rootView;
    }

    private List<WeatherData> getWeather(){
        List<WeatherData> weatherDatalist=new ArrayList<>();
        for(int index=0;index<7;index++){
            GregorianCalendar gregorianCalendar=new GregorianCalendar();
            gregorianCalendar.add(GregorianCalendar.DATE,index);
            Date date=gregorianCalendar.getTime();
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("EE MM DD");
            WeatherData weatherData=new WeatherData(100.0,80,25,36,"clear","very clear",simpleDateFormat.format(date));
            weatherDatalist.add(weatherData);
        }
        return weatherDatalist;
    }

    @Override
    public void WeatherClicked(WeatherData weatherData) {

    }
}
