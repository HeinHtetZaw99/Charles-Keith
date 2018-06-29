package com.daniel.user.charleskeith.network.responese;

import com.daniel.user.charleskeith.data.vo.ProductsVO;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GetCKResponses {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("page")
    private int page;

    @SerializedName("newProducts")
    private List<ProductsVO> newProducts;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public int getPage() {
        return page;
    }

    public List<ProductsVO> getNewProducts() {
        if (newProducts == null) {
            newProducts = new ArrayList<>();
        }
        return newProducts;
    }
}
