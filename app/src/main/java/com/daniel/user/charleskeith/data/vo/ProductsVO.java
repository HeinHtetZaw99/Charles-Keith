package com.daniel.user.charleskeith.data.vo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;


@Entity(tableName = "products")
public class ProductsVO {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "productId")
    @SerializedName("product-id")
    private String productId;

    @ColumnInfo(name = "productImg")
    @SerializedName("product-image")
    private String productImage;

    @ColumnInfo(name = "productTitle")
    @SerializedName("product-title")
    private String productTitle;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }
}
