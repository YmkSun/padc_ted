package com.ymksun.dev.ted.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yemyokyaw on 1/30/18.
 */

public class MostViewedTalksFragment extends Fragment {

    public static MostViewedTalksFragment newInstance() {
        MostViewedTalksFragment fragment = new MostViewedTalksFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
