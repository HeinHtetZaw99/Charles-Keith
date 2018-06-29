package com.daniel.user.charleskeith.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.daniel.user.charleskeith.R;
import com.daniel.user.charleskeith.data.vo.ProductsVO;

import java.util.ArrayList;
import java.util.List;

public class Slider_Adapter extends PagerAdapter {
    public int[] slider_images = {R.drawable.shoe, R.drawable.shoe1, R.drawable.shoe, R.drawable.shoe1, R.drawable.shoe, R.drawable.shoe1};
    LayoutInflater layoutInflater;
    private List<ProductsVO> mProducts;
    private Context context;

    public Slider_Adapter(Context context) {
        this.context = context;
        mProducts = new ArrayList<>();

    }

    @Override
    public int getCount() {
        return mProducts.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.view_item_image_layout, container, false);

        ImageView sliderImageView = view.findViewById(R.id.image_view);

        Glide.with(sliderImageView.getContext()).load(mProducts.get(position).getProductImage())
                .into(sliderImageView);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }

    public void setmProducts(List<ProductsVO> mProducts) {
        this.mProducts = mProducts;
        notifyDataSetChanged();
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return super.getItemPosition(object);
    }
}
