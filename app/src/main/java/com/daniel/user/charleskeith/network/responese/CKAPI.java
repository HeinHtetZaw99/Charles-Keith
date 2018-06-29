package com.daniel.user.charleskeith.network.responese;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface CKAPI {
    @FormUrlEncoded
    @POST("getNewProducts.php")
    Observable<GetCKResponses> loadCKProducts(
            @Field("page") String page,
            @Field("access_token") String access_token
    );
}
