package vn.edu.usth.usthweather;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

public class WeatherActivity extends AppCompatActivity {
    ViewPagerFragmentAdapter viewPagerFragmentAdapter;
    ViewPager2 viewPager2;
    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        Log.i(TAG, "Program is created");

        viewPager2 = findViewById(R.id.view_pager);
        viewPagerFragmentAdapter = new ViewPagerFragmentAdapter(this);
        viewPager2.setAdapter(viewPagerFragmentAdapter);

//        ForecastFragment forecastFragment = new ForecastFragment();
//        getSupportFragmentManager().beginTransaction().add(R.id.container, forecastFragment).commit();
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.i(TAG, "Program is started");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.i(TAG, "Program is resumed");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.i(TAG, "Program is paused");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.i(TAG, "Program is stopped");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(TAG, "Program is destroyed");
    }
}