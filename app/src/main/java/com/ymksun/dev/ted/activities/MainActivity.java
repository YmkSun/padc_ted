package com.ymksun.dev.ted.activities;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
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
import com.ymksun.dev.ted.fragments.SurpriseMeFragment;
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

        setUpFragements();
        tlMain.setupWithViewPager(vpFragmentMain);
        setUpTabIcon();
        setTabToContext(tlMain.getTabAt(0), true);

        tlMain.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(vpFragmentMain) {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                super.onTabSelected(tab);
                setTabToContext(tab, true);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                super.onTabUnselected(tab);
                setTabToContext(tab, false);
            }
        });
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
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setUpTabIcon() {
        for (int i = 0; i < AppConstants.tabIcons.length; i++) {
            tlMain.getTabAt(i).setIcon(AppConstants.tabIcons[i]);
        }
    }

    public void setUpFragements() {
        mFragmentPagerAdapter = new MainFragmentPagerAdapter(getSupportFragmentManager(), this);
        mFragmentPagerAdapter.addTab(new TalksFragment(), "");
        mFragmentPagerAdapter.addTab(new PlaylistsFragment(), "");
        mFragmentPagerAdapter.addTab(new PodcastsFragment(), "");
        mFragmentPagerAdapter.addTab(new SurpriseMeFragment(), "");
        mFragmentPagerAdapter.addTab(new MyTalksFragment(), "");
        vpFragmentMain.setAdapter(mFragmentPagerAdapter);
    }

    public void setTabToContext(TabLayout.Tab tab, boolean isActive) {
        int tabIconColor = ContextCompat.getColor(getApplicationContext(), isActive ? R.color.accent : R.color.gray_full);
        tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
        if (isActive)
            tvActionBarTitle.setText(AppConstants.tabTitles[tab.getPosition()]);
    }

    @Override
    public void setActionBarTitle(String title) {
        Toast.makeText(this, title, Toast.LENGTH_SHORT).show();
        tvActionBarTitle.setText(title);
    }


}
