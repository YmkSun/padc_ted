package com.ymksun.dev.ted.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.Toast;

import com.ymksun.dev.ted.delegates.TEDAppDelegate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yemyokyaw on 1/26/18.
 */

public class MainFragmentPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mFragments = new ArrayList<>();
    private List<String> mFragmentTitles = new ArrayList<>();

    TEDAppDelegate mDelegate;

    public MainFragmentPagerAdapter(FragmentManager fm, TEDAppDelegate tedAppDelegate) {
        super(fm);
        mDelegate = tedAppDelegate;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }


    public void addTab(Fragment fragment, String title) {
        mFragments.add(fragment);
        mFragmentTitles.add(title);
    }
}
