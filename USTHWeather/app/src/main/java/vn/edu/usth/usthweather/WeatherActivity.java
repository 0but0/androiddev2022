package vn.edu.usth.usthweather;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
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
//                Toast.makeText(this, "Refreshing...", Toast.LENGTH_SHORT).show();
//                super.onRestart();
                Refresh();
                return true;
            case R.id.settings:
                Intent intent = new Intent(this, PrefActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("StaticFieldLeak")
    public void Refresh(){
//        final Handler handler = new Handler(Looper.getMainLooper()){
//            @Override
//            public void handleMessage(@NonNull Message msg) {
//                String content = msg.getData().getString("Server Response");
//                Toast toast = Toast.makeText(getApplicationContext(), content, Toast.LENGTH_SHORT);
//                toast.show();
//            }
//        };
//        Thread t = new Thread(()->{
//            try{
//                for (int i=0; i<5; i++){
//                    Thread.sleep(1000);
//                }
//            } catch(InterruptedException e){
//                e.printStackTrace();
//            }
//            Bundle bundle = new Bundle();
//            bundle.putString("Server Response","New content is ready now");
//            Message msg = new Message();
//            msg.setData(bundle);
//            handler.sendMessage(msg);
//        });
//        t.start();
        AsyncTask<Integer, Integer, Integer> taskA = new AsyncTask<Integer, Integer, Integer>() {
            @Override
            protected void onPreExecute() {
                Toast toast = Toast.makeText(getApplicationContext(), "Start to delay the app", Toast.LENGTH_SHORT);
                toast.show();
            }

            @Override
            protected void onPostExecute(Integer integer) {
                Toast toast = Toast.makeText(getApplicationContext(), "Finish delaying the app", Toast.LENGTH_SHORT);
                toast.show();
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                Toast toast = Toast.makeText(getApplicationContext(), "Updating "+values[0], Toast.LENGTH_SHORT);
                toast.show();
            }

            @SuppressLint("StaticFieldLeak")
            @Override
            protected Integer doInBackground(Integer... integers) {
                try{
                    for (int i=0; i<5; i++){
                        Thread.sleep(1000);
                        publishProgress(i);
                    }
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
                return 0;
        }
    };
    taskA.execute();
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