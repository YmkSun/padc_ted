package com.ymksun.dev.ted.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.ymksun.dev.ted.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yemyokyaw on 1/26/18.
 */

public class TalksFragment extends Fragment implements View.OnClickListener {

    @BindView(R.id.tv_frag_newest_talks)
    TextView tvNewestTalks;

    @BindView(R.id.tv_frag_trending_talks)
    TextView tvTrendingTalks;

    @BindView(R.id.tv_frag_most_viewed_talks)
    TextView tvMostViewedTalks;

    @BindView(R.id.tv_frag_hidden_gems)
    TextView tvHiddenGemsTalks;

    @BindView(R.id.fl_frag_talk_child)
    FrameLayout flTalkViews;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_talks, container, false);
        ButterKnife.bind(this, view);

        setActiveFragment(new NewestTalksFragment());
        changeSubTabTextColor(R.id.tv_frag_newest_talks);

        tvNewestTalks.setOnClickListener(this);
        tvMostViewedTalks.setOnClickListener(this);
        tvTrendingTalks.setOnClickListener(this);
        tvHiddenGemsTalks.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View clickedView) {
        int id = clickedView.getId();
        switch (id) {
            case R.id.tv_frag_newest_talks: {
                setActiveFragment(new NewestTalksFragment());
                changeSubTabTextColor(id);
                break;
            }
            case R.id.tv_frag_trending_talks: {
                setActiveFragment(new TrendingTalksFragment());
                changeSubTabTextColor(id);
                break;
            }
            case R.id.tv_frag_most_viewed_talks: {
                setActiveFragment(new MostViewedTalksFragment());
                changeSubTabTextColor(id);
                break;
            }
            case R.id.tv_frag_hidden_gems: {
                setActiveFragment(new HiddenGemsTalksFragment());
                changeSubTabTextColor(id);
                break;
            }
        }
    }

    public void setActiveFragment(Fragment fragment) {
        FragmentManager manager = getFragmentManager();
        manager.beginTransaction().replace(R.id.fl_frag_talk_child, fragment).commit();
    }

    public void changeSubTabTextColor(int id) {
        tvNewestTalks.setTextColor(getResources().getColor(id == tvNewestTalks.getId() ? R.color.accent : R.color.gray_full));
        tvTrendingTalks.setTextColor(getResources().getColor(id == tvTrendingTalks.getId() ? R.color.accent : R.color.gray_full));
        tvMostViewedTalks.setTextColor(getResources().getColor(id == tvMostViewedTalks.getId() ? R.color.accent : R.color.gray_full));
        tvHiddenGemsTalks.setTextColor(getResources().getColor(id == tvHiddenGemsTalks.getId() ? R.color.accent : R.color.gray_full));
    }

}
