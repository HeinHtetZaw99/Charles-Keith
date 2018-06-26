package com.daniel.user.charleskeith.viewholders;

import android.view.View;

import com.daniel.user.charleskeith.delegates.NewInDelegate;

public class NewInViewHolder extends BaseViewHolder {
    private NewInDelegate newInDelegate;

    public NewInViewHolder(View itemview, NewInDelegate newInDelegate) {
        super(itemview);
        this.newInDelegate = newInDelegate;
    }

    @Override
    public void onClick(View v) {
        newInDelegate.onTapNewInItem();
    }
}
