package com.ymksun.dev.ted.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ymksun.dev.ted.delegates.TEDAppDelegate;

/**
 * Created by yemyokyaw on 1/26/18.
 */

public class PodcastsFragment extends Fragment {

    public static PodcastsFragment newInstance() {
        PodcastsFragment fragment = new PodcastsFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

}
