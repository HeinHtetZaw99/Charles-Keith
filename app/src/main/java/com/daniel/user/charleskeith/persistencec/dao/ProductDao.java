package com.daniel.user.charleskeith.persistencec.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.daniel.user.charleskeith.data.vo.ProductsVO;

import java.util.List;

@Dao
public interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<ProductsVO> productVOS);

    @Query("select * from products")
    LiveData<List<ProductsVO>> getAllData();

    @Query("select * from products where productId = :id")
    List<ProductsVO> getProductById(String id);

    @Query("select * from products")
    List<ProductsVO> getAllProduct();

    @Query("select * from products where productId = :id")
    LiveData<List<ProductsVO>> getProductLDById(String id);
}
