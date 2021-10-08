package vn.edu.usth.usthweather;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerFragmentAdapter extends FragmentStateAdapter {
    public ViewPagerFragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new WeatherAndForecastFragment();
            case 1:
                return new WeatherAndForecastFragment();
            case 2:
                return new WeatherAndForecastFragment();
        }
        return new BlankFragment();
    }

    @Override
    public int getItemCount() {

        return 3;
    }
}
