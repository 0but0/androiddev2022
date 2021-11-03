package vn.edu.usth.usthweather;
import android.content.Intent;
import android.media.MediaPlayer;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.io.InputStream;

public class WeatherActivity extends AppCompatActivity {
    private ViewPagerFragmentAdapter viewPagerFragmentAdapter;
    private ViewPager2 viewPager2;
    private TabLayout tabLayout;
    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        Log.i(TAG, "Program is created");

        viewPager2 = findViewById(R.id.view_pager);
        viewPagerFragmentAdapter = new ViewPagerFragmentAdapter(this);
        viewPager2.setAdapter(viewPagerFragmentAdapter);

        tabLayout = findViewById(R.id.tab_layout);
        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            switch (position){
                case 0:
                    tab.setText(getString(R.string.Tab0));
                    break;
                case 1:
                    tab.setText(getString(R.string.Tab1));
                    break;
                case 2:
                    tab.setText(getString(R.string.Tab2));
                    break;
            }
        }).attach();

        MediaPlayer mp = MediaPlayer.create(getBaseContext(), R.raw.forecastvtv);
        mp.start();



//        ForecastFragment forecastFragment = new ForecastFragment();
//        getSupportFragmentManager().beginTransaction().add(R.id.container, forecastFragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.refresh:
                Toast.makeText(this, "Refreshing...", Toast.LENGTH_SHORT).show();
                super.onRestart();
                return true;
            case R.id.settings:
                Intent intent = new Intent(this, PrefActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
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