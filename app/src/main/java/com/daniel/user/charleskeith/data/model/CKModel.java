package com.daniel.user.charleskeith.data.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.util.Log;

import com.daniel.user.charleskeith.CharlesAndKeithAPP;
import com.daniel.user.charleskeith.data.vo.ProductsVO;
import com.daniel.user.charleskeith.network.responese.GetCKResponses;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CKModel extends BaseModel {

    private static CKModel mInstance;
    private String pageIndex = "1";

    protected CKModel(Context context) {
        super(context);
    }


    public static CKModel getmInstance() {
        if (mInstance == null) {
            throw new RuntimeException("CKModel is being involved before initialized");
        }
        return mInstance;
    }

    public static void initCKModel(Context context) {

        mInstance = new CKModel(context);
    }

    public void startLoadingCKProducts(final MutableLiveData<List<ProductsVO>> productsLD, final MutableLiveData<String> errorLD) {
        mAPI.loadCKProducts(pageIndex, CharlesAndKeithAPP.ACCESS_TOKEN)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetCKResponses>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetCKResponses getCKResponses) {
                        if (getCKResponses != null && getCKResponses.getNewProducts().size() > 0) {

                            productsLD.setValue(getCKResponses.getNewProducts());

                            pageIndex = pageIndex + 1;
                            addNewProductsToDB(getCKResponses.getNewProducts());
                        } else
                            Log.d(CharlesAndKeithAPP.APP_LOG, "LD in Model : code =  " + getCKResponses.getCode());
                    }

                    @Override
                    public void onError(Throwable e) {
                        errorLD.setValue(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void addNewProductsToDB(List<ProductsVO> productsVOS) {
        productsDB.productDao().insertAll(productsVOS);
    }

    public List<ProductsVO> getProductById(String productId) {
        return productsDB.productDao().getProductById(productId);
    }

    public LiveData<List<ProductsVO>> getAllProductLiveData() {
        return productsDB.productDao().getAllData();
    }

    public LiveData<List<ProductsVO>> getProductLiveDataById(String id) {
        return productsDB.productDao().getProductLDById(id);
    }

    public List<ProductsVO> getAllProduct() {
        return productsDB.productDao().getAllProduct();
    }

}
