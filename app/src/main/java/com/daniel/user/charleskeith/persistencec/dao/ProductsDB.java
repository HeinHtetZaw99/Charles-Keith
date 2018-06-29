package com.daniel.user.charleskeith.persistencec.dao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.daniel.user.charleskeith.data.vo.ProductsVO;

@Database(entities = {ProductsVO.class}, version = 1, exportSchema = false)
public abstract class ProductsDB extends RoomDatabase {
    private static ProductsDB mInstance;
    private static String DB_NAME = "ck_products_db";

    public static ProductsDB getmInstance(Context context) {
        if (mInstance == null) {
            mInstance = Room.databaseBuilder(context, ProductsDB.class, DB_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return mInstance;
    }

    public abstract ProductDao productDao();
}
