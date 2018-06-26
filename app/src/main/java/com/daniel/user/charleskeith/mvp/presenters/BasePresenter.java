package com.daniel.user.charleskeith.mvp.presenters;

import com.daniel.user.charleskeith.mvp.views.BaseView;

public abstract class BasePresenter<T extends BaseView> {
    protected T mView;

    public BasePresenter(T mView) {
        this.mView = mView;
    }
}
