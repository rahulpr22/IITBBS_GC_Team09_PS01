package com.example.livescorecard;

import android.content.Context;import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


public class MyAdapter extends FragmentPagerAdapter {    private Context myContext;
    int totalTabs;    public MyAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                LiveFragment liveFragment = new LiveFragment();
                return liveFragment;
            case 1:
                UpcomingFragment futureFragment = new UpcomingFragment();
                return futureFragment;
            case 2:
                RecentFragment recentFragment = new RecentFragment();
                return recentFragment;
            default:
                return null;
        }
    }
    // this counts total number of tabs
    @Override
    public int getCount() {
        return totalTabs;
    }
}