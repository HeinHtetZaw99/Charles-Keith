package com.daniel.user.charleskeith.mvp.presenters;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.daniel.user.charleskeith.mvp.views.BaseView;

public abstract class BasePresenter<T extends BaseView> extends ViewModel {
    protected T mView;
    protected MutableLiveData<String> mErrorLD;

    public void initPresenter(T mView) {
        this.mView = mView;
        mErrorLD = new MutableLiveData<>();
    }

    public LiveData<String> getErrorLD() {
        return mErrorLD;
    }
}
