package com.example.user.weatherrxjava_example1_complexrecyclerview.views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.weatherrxjava_example1_complexrecyclerview.R;
import com.example.user.weatherrxjava_example1_complexrecyclerview.entities.WeatherData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 8/12/2017.
 */

public class WeatherAdapter extends RecyclerView.Adapter<WeatherViewHolder> implements View.OnClickListener {

    public static final int VIEW_TYPE_HEADER=1;
    public static final int VIEW_TYPE_BODY=2;

    private List<WeatherData> weatherDataList;
    private LayoutInflater inflater;
    private Context context;
    private WeatherListener listener;

    public WeatherAdapter(Context context, WeatherListener listener) {
        this.context = context;
        this.listener = listener;
        inflater=LayoutInflater.from(context);
        weatherDataList=new ArrayList<>();
    }

    public void setWeatherDataList(List<WeatherData> list) {
        weatherDataList.clear();
        weatherDataList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0){
            return VIEW_TYPE_HEADER;
        }
        position--;
        if(position<weatherDataList.size()){
            return VIEW_TYPE_BODY;
        }
        position=position-weatherDataList.size();
        throw new IllegalArgumentException("we are at the end of the list");
    }

    @Override
    public WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View headerView=inflater.inflate(R.layout.list_weather_today,parent,false);
        View bodyView=inflater.inflate(R.layout.list_weather_item,parent,false);

        if(viewType==VIEW_TYPE_HEADER){
            headerView.setOnClickListener(this);
            return new WeatherViewHolder(headerView);
        }else{
            bodyView.setOnClickListener(this);
            return new WeatherViewHolder(bodyView);
        }
    }

    @Override
    public void onBindViewHolder(WeatherViewHolder holder, int position) {
        holder.populate(weatherDataList.get(position),position);
    }

    @Override
    public int getItemCount() {
        return weatherDataList.size();
    }

    @Override
    public void onClick(View v) {
        if(v.getTag() instanceof WeatherData){
            listener.WeatherClicked((WeatherData)v.getTag());
        }
    }

    public interface WeatherListener{
        void WeatherClicked(WeatherData weatherData);
    }
}
