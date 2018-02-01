package com.ymksun.dev.ted.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ymksun.dev.ted.R;
import com.ymksun.dev.ted.activities.MainActivity;
import com.ymksun.dev.ted.adapters.MainFragmentPagerAdapter;
import com.ymksun.dev.ted.adapters.TalksFragmentPagerAdapter;
import com.ymksun.dev.ted.components.SmartChildViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yemyokyaw on 1/26/18.
 */

public class TalksFragment extends Fragment {

    @BindView(R.id.tl_talks_main)
    TabLayout tlTalks;

    @BindView(R.id.pager_fragments_talks)
    SmartChildViewPager vpFragmentTalks;

    public TalksFragmentPagerAdapter mFragmentPagerAdapter;

    public static TalksFragment newInstance() {
        TalksFragment fragment = new TalksFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_talks, container, false);
        ButterKnife.bind(this, view);
        Toast.makeText(getActivity(), "Talks", Toast.LENGTH_LONG).show();
        navigateToViewPager();
        return view;
    }

    public void navigateToViewPager() {
        mFragmentPagerAdapter = new TalksFragmentPagerAdapter(getFragmentManager());
        mFragmentPagerAdapter.addTab(NewestTalksFragment.newInstance(), "Newest");
        mFragmentPagerAdapter.addTab(TrendingTalksFragment.newInstance(), "Trending");
        mFragmentPagerAdapter.addTab(MostViewedTalksFragment.newInstance(), "Most viewed");
        mFragmentPagerAdapter.addTab(HiddenGemsTalksFragment.newInstance(), "Hidden gems");
        vpFragmentTalks.setAdapter(mFragmentPagerAdapter);
        tlTalks.setupWithViewPager(vpFragmentTalks);

        Toast.makeText(getActivity(), "Talks navigate", Toast.LENGTH_LONG).show();
    }
}
