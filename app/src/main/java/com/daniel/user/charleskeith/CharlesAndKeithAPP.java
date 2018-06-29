package com.daniel.user.charleskeith;

import android.app.Application;

import com.daniel.user.charleskeith.data.model.CKModel;

public class CharlesAndKeithAPP extends Application {
    public static final String APP_LOG = "CK";
    public static final String ACCESS_TOKEN = "b002c7e1a528b7cb460933fc2875e916";
    public static final int PAGE_NUMBER = 2;
    public static final String PATH = "getNewProducts.php";
    public static final String BASE_URL = "http://padcmyanmar.com/padc-5/ck/";

    @Override
    public void onCreate() {
        super.onCreate();
        CKModel.initCKModel(getApplicationContext());
    }
}
