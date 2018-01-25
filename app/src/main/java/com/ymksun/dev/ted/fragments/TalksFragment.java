package com.ymksun.dev.ted.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ymksun.dev.ted.R;

/**
 * Created by yemyokyaw on 1/26/18.
 */

public class TalksFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.view_actionbar_title, null, false);
        TextView tvActionBarTitle = view.findViewById(R.id.tv_action_bar_title);
        tvActionBarTitle.setText(R.string.title_talks);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
