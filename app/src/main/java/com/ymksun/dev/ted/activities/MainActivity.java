package com.ymksun.dev.ted.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.ymksun.dev.ted.R;
import com.ymksun.dev.ted.adapters.MainFragmentPagerAdapter;
import com.ymksun.dev.ted.fragments.TalksFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tl_main)
    TabLayout tlMain;

    @BindView(R.id.pager_fragments_main)
    ViewPager vpFragmentMain;

    @BindView(R.id.toolbar_main)
            Toolbar mToolBar;

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

    public void navigateToViewPager() {
        mFragmentPagerAdapter = new MainFragmentPagerAdapter(getSupportFragmentManager());
        mFragmentPagerAdapter.addTab(new TalksFragment(), "");
        mFragmentPagerAdapter.addTab(new TalksFragment(), "");
        mFragmentPagerAdapter.addTab(new TalksFragment(), "");
        mFragmentPagerAdapter.addTab(new TalksFragment(), "");
        mFragmentPagerAdapter.addTab(new TalksFragment(), "");
        vpFragmentMain.setAdapter(mFragmentPagerAdapter);
        tlMain.setupWithViewPager(vpFragmentMain);
        tlMain.getTabAt(0).setIcon(R.drawable.ic_format_list_bulleted_gray_24dp);
        tlMain.getTabAt(1).setIcon(R.drawable.ic_video_library_gray_24dp);
        tlMain.getTabAt(2).setIcon(R.drawable.ic_music_note_gray_24dp);
        tlMain.getTabAt(3).setIcon(R.drawable.ic_lightbulb_outline_gray_24dp);
        tlMain.getTabAt(4).setIcon(R.drawable.ic_account_circle_gray_24dp);

    }
}
