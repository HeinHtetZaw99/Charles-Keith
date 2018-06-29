package com.daniel.user.charleskeith.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.daniel.user.charleskeith.R;
import com.daniel.user.charleskeith.data.vo.ProductsVO;
import com.daniel.user.charleskeith.delegates.NewInDelegate;

import butterknife.BindView;

public class NewInViewHolder2 extends BaseViewHolder<ProductsVO> {
    @BindView(R.id.item_name)
    TextView mItemName;
    @BindView(R.id.item_picture)
    ImageView mItemPicture;
    private NewInDelegate newInDelegate;
    private ProductsVO productsVO;


    public NewInViewHolder2(View itemview, NewInDelegate newInDelegate) {
        super(itemview);
        this.newInDelegate = newInDelegate;

    }

    @Override
    public void onClick(View v) {
        newInDelegate.onTapNewInItem(productsVO);
    }

    @Override
    public void setmData(ProductsVO mData) {
        productsVO = mData;
        mItemName.setText(mData.getProductTitle());


        Glide.with(mItemPicture.getContext())
                .load(mData.getProductImage())
                .into(mItemPicture);
    }


}
