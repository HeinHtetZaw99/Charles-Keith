package com.daniel.user.charleskeith.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.daniel.user.charleskeith.R;
import com.daniel.user.charleskeith.data.vo.ProductsVO;
import com.daniel.user.charleskeith.delegates.NewInDelegate;

import butterknife.BindView;

public class NewInViewHolder extends BaseViewHolder<ProductsVO> {
    private NewInDelegate newInDelegate;

    @BindView(R.id.item_name_lg)
    TextView mItemName;
    @BindView(R.id.item_picture_lg)
    ImageView mItemPicture;
    private ProductsVO productsVO;


    public NewInViewHolder(View itemview, NewInDelegate newInDelegate) {
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
