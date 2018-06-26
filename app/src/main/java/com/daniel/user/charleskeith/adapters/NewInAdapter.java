package com.daniel.user.charleskeith.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.daniel.user.charleskeith.R;
import com.daniel.user.charleskeith.delegates.NewInDelegate;
import com.daniel.user.charleskeith.viewholders.NewInViewHolder;

public class NewInAdapter extends BaseRecyclerAdapter<NewInViewHolder> {
    private NewInDelegate newInDelegate;

    public NewInAdapter(Context context, NewInDelegate newInDelegate) {
        super(context);
        this.newInDelegate = newInDelegate;
    }

    @NonNull
    @Override
    public NewInViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View newInView = mLayoutInflator.inflate(R.layout.view_item_new_in_lg, parent, false);
        return new NewInViewHolder(newInView, newInDelegate);
    }
}
