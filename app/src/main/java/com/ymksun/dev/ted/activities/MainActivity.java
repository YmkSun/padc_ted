package com.ymksun.dev.ted.activities;

import android.os.Bundle;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.ymksun.dev.ted.R;
import com.ymksun.dev.ted.adapters.MainFragmentPagerAdapter;
import com.ymksun.dev.ted.delegates.TEDAppDelegate;
import com.ymksun.dev.ted.fragments.MyTalksFragment;
import com.ymksun.dev.ted.fragments.PlaylistsFragment;
import com.ymksun.dev.ted.fragments.PodcastsFragment;
import com.ymksun.dev.ted.fragments.SupriseMeFragment;
import com.ymksun.dev.ted.fragments.TalksFragment;
import com.ymksun.dev.ted.utils.AppConstants;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements TEDAppDelegate {



    @BindView(R.id.tl_main)
    TabLayout tlMain;

    @BindView(R.id.pager_fragments_main)
    ViewPager vpFragmentMain;

    @BindView(R.id.toolbar_main)
    Toolbar mToolBar;

    @BindView(R.id.tv_action_bar_title)
    TextView tvActionBarTitle;

    MainFragmentPagerAdapter mFragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);

        setSupportActionBar(mToolBar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);

        navigateToViewPager();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.left_menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addIconsToTab() {

    }

    public void navigateToViewPager() {
        mFragmentPagerAdapter = new MainFragmentPagerAdapter(getSupportFragmentManager(), this);
        mFragmentPagerAdapter.addTab(TalksFragment.newInstance(), "Talks");
        mFragmentPagerAdapter.addTab(PlaylistsFragment.newInstance(), "Playlists");
        mFragmentPagerAdapter.addTab(PodcastsFragment.newInstance(), "Podcasts");
        mFragmentPagerAdapter.addTab(SupriseMeFragment.newInstance(), "Suprise Me");
        mFragmentPagerAdapter.addTab(MyTalksFragment.newInstance(), "My Talks");
        vpFragmentMain.setAdapter(mFragmentPagerAdapter);
        tlMain.setupWithViewPager(vpFragmentMain);
        for(int i = 0; i < AppConstants.tabIcons.length; i++) {
            tlMain.getTabAt(i).setIcon(AppConstants.tabIcons[i]);
        }
    }

    @Override
    public void setActionBarTitle(String title) {
        Toast.makeText(this, title, Toast.LENGTH_SHORT).show();
        tvActionBarTitle.setText(title);
    }
}
