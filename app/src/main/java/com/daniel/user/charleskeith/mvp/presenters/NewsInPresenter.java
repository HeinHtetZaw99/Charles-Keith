package com.daniel.user.charleskeith.mvp.presenters;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.daniel.user.charleskeith.data.model.CKModel;
import com.daniel.user.charleskeith.data.vo.ProductsVO;
import com.daniel.user.charleskeith.delegates.NewInDelegate;
import com.daniel.user.charleskeith.mvp.views.NewInView;

import java.util.List;

public class NewsInPresenter extends BasePresenter<NewInView> implements NewInDelegate {

    private MutableLiveData<List<ProductsVO>> mProductLD;


    @Override
    public void initPresenter(NewInView mView) {
        super.initPresenter(mView);
        mProductLD = new MutableLiveData<>();
        CKModel.getmInstance().startLoadingCKProducts(mProductLD, mErrorLD);
    }

    public LiveData<List<ProductsVO>> getProductsLD() {
        return mProductLD;
    }

    @Override
    public void onTapColumnOneButton() {


    }

    @Override
    public void ontapColumnTwoButton() {

    }

    @Override
    public void onTapNewInItem(ProductsVO productsVO) {
        mView.launchItemDetailsScreen(productsVO.getProductId());
    }


}
