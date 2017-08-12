package com.example.user.weatherrxjava_example1_complexrecyclerview.activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user.weatherrxjava_example1_complexrecyclerview.R;
import com.example.user.weatherrxjava_example1_complexrecyclerview.fragments.ForecastFragment;

public class MainActivity extends BaseFragmentActivity {

    //RecyclerView when we have different layout and also it is about how to define Fragment and also populate data
    //How to use Interface
    //About Abstract class
    @Override
    protected Fragment createFragment() {
        return ForecastFragment.newInstance();
    }
}
