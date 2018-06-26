package com.daniel.user.charleskeith.mvp.presenters;

import com.daniel.user.charleskeith.delegates.NewInDelegate;
import com.daniel.user.charleskeith.mvp.views.NewInView;

public class NewsInPresenter extends BasePresenter<NewInView> implements NewInDelegate {

    public NewsInPresenter(NewInView mView) {
        super(mView);
    }

    @Override
    public void onTapColumnOneButton() {

    }

    @Override
    public void ontapColumnTwoButton() {

    }

    @Override
    public void onTapNewInItem() {
        mView.launchItemDetailsScreen();
    }


}
