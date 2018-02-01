package com.ymksun.dev.ted.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.ymksun.dev.ted.data.vo.TalksVO;
import com.ymksun.dev.ted.viewholders.NewestTalksViewHolder;

/**
 * Created by yemyokyaw on 2/2/18.
 */

public class NewestTalksRecyclerAdapter extends BaseRecyclerAdapter<NewestTalksViewHolder, TalksVO> {
    public NewestTalksRecyclerAdapter(Context context) {
        super(context);
    }

    @Override
    public NewestTalksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }
}
