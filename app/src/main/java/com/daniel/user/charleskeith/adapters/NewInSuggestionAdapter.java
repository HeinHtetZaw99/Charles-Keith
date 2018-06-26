package com.daniel.user.charleskeith.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.daniel.user.charleskeith.R;
import com.daniel.user.charleskeith.viewholders.NewInDetailsViewHolder;

public class NewInSuggestionAdapter extends BaseRecyclerAdapter<NewInDetailsViewHolder> {
    public NewInSuggestionAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public NewInDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View newInDetailsView = mLayoutInflator.inflate(R.layout.view_item_suggestion, parent, false);
        return new NewInDetailsViewHolder(newInDetailsView);
    }
}
