package com.daniel.user.charleskeith.mvp.presenters;

import android.arch.lifecycle.LiveData;

import com.daniel.user.charleskeith.data.model.CKModel;
import com.daniel.user.charleskeith.data.vo.ProductsVO;
import com.daniel.user.charleskeith.delegates.NewInDelegate;
import com.daniel.user.charleskeith.mvp.views.NewInDetailsView;

import java.util.List;

public class NewInDetailsPresenter extends BasePresenter<NewInDetailsView> implements NewInDelegate {

    @Override
    public void initPresenter(NewInDetailsView mView) {
        super.initPresenter(mView);
    }

    @Override
    public void onTapColumnOneButton() {

    }

    @Override
    public void ontapColumnTwoButton() {

    }

    @Override
    public void onTapNewInItem(ProductsVO productsVO) {

    }

    public LiveData<List<ProductsVO>> getAllProductLD() {
        return CKModel.getmInstance().getAllProductLiveData();
    }

    public LiveData<List<ProductsVO>> getProductLDById(String id) {
        return CKModel.getmInstance().getProductLiveDataById(id);
    }


    public List<ProductsVO> getProductById(String productId) {
        return CKModel.getmInstance().getProductById(productId);
    }
}
