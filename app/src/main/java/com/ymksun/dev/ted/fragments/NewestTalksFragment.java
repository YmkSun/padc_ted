package com.ymksun.dev.ted.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ymksun.dev.ted.R;
import com.ymksun.dev.ted.adapters.NewestTalksRecyclerAdapter;
import com.ymksun.dev.ted.components.EmptyViewPod;
import com.ymksun.dev.ted.components.SmartRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yemyokyaw on 1/30/18.
 */

public class NewestTalksFragment extends Fragment {

    @BindView(R.id.rv_newest_talks)
    SmartRecyclerView rvNewestTalks;


    @BindView(R.id.vp_empty_talk)
    EmptyViewPod vpEmptyTalk;

    NewestTalksRecyclerAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_newest_talks, container, false);
        ButterKnife.bind(this, view);

        rvNewestTalks.setEmptyView(vpEmptyTalk);
        rvNewestTalks.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mAdapter = new NewestTalksRecyclerAdapter(getContext());
        rvNewestTalks.setAdapter(mAdapter);

        return view;
    }
}
