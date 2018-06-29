package com.daniel.user.charleskeith.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

public abstract class BaseViewHolder<W> extends RecyclerView.ViewHolder implements View.OnClickListener {
//    private W mData ;

    public BaseViewHolder(View itemview) {
        super(itemview);
        ButterKnife.bind(this, itemview);
        itemview.setOnClickListener(this);
    }

    public abstract void setmData(W mData);
}
