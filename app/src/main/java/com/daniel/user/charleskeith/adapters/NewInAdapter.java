package com.daniel.user.charleskeith.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.daniel.user.charleskeith.R;
import com.daniel.user.charleskeith.data.vo.ProductsVO;
import com.daniel.user.charleskeith.delegates.NewInDelegate;
import com.daniel.user.charleskeith.viewholders.BaseViewHolder;
import com.daniel.user.charleskeith.viewholders.NewInViewHolder2;

public class NewInAdapter extends BaseRecyclerAdapter<BaseViewHolder, ProductsVO> {
    private NewInDelegate newInDelegate;
    private int columnNo;

    public NewInAdapter(Context context, NewInDelegate newInDelegate, int columnNo) {
        super(context);
        this.newInDelegate = newInDelegate;
        this.columnNo = columnNo;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

//        if(columnNo == 1){
//            View view = mLayoutInflator.inflate(R.layout.view_item_new_in_lg,parent,false);
//            return new NewInViewHolder(view, newInDelegate);
//        }else {
        View view = mLayoutInflator.inflate(R.layout.view_item_new_in, parent, false);
        return new NewInViewHolder2(view, newInDelegate);
//        }

    }
}
