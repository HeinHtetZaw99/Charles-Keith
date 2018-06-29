package com.daniel.user.charleskeith.delegates;

import com.daniel.user.charleskeith.data.vo.ProductsVO;

public interface NewInDelegate {
    void onTapColumnOneButton();

    void ontapColumnTwoButton();

    void onTapNewInItem(ProductsVO productsVO);
}
