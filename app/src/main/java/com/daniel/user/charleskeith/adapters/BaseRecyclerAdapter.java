package com.daniel.user.charleskeith.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.daniel.user.charleskeith.viewholders.BaseViewHolder;

public class BaseRecyclerAdapter<T extends BaseViewHolder> extends RecyclerView.Adapter<T> {

    //    protected List<W> mData;
    protected LayoutInflater mLayoutInflator;

    public BaseRecyclerAdapter(Context context) {
//        mData = new ArrayList<>();
        mLayoutInflator = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public T onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull T holder, int position) {
//            holder.setmData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return 10;
    }
//
//    public W getItemAt(int position) {
//        if (position < mData.size() - 1)
//            return mData.get(position);
//
//        return null;
//    }
//
//    public List<W> getItems() {
//        if (mData == null)
//            return new ArrayList<>();
//
//        return mData;
//    }
//
//    public void removeData(W data) {
//        mData.remove(data);
//        notifyDataSetChanged();
//    }
//
//    public void addNewData(W data) {
//        mData.add(data);
//        notifyDataSetChanged();
//    }
//
//    public void clearData() {
//        mData = new ArrayList<>();
//        notifyDataSetChanged();
//    }

}
