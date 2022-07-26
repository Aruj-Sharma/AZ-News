package com.example.aznews.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.aznews.fragments.EntertainmentFragment;
import com.example.aznews.fragments.HealthFragment;
import com.example.aznews.fragments.HomeFragment;
import com.example.aznews.fragments.ScienceFragment;
import com.example.aznews.fragments.SportsFragment;
import com.example.aznews.fragments.TechnologyFragment;

public class PagerAdapter extends FragmentStateAdapter {

    private String [] titles = {"Home", "Sports", "Health", "Science", "Entertainment", "Technology"};


    public PagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position)
        {
            case 0:
                return new HomeFragment();
            case 1:
                return new SportsFragment();
            case 2:
                return new HealthFragment();
            case 3:
                return new ScienceFragment();
            case 4:
                return new EntertainmentFragment();
            case 5:
                return new TechnologyFragment();

        }

        return new HomeFragment();

    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
