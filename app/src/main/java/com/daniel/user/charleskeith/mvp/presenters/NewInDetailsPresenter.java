package com.daniel.user.charleskeith.mvp.presenters;

import com.daniel.user.charleskeith.delegates.NewInDelegate;
import com.daniel.user.charleskeith.mvp.views.NewInDetailsView;

public class NewInDetailsPresenter extends BasePresenter<NewInDetailsView> implements NewInDelegate {

    public NewInDetailsPresenter(NewInDetailsView mView) {
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

    }
}
