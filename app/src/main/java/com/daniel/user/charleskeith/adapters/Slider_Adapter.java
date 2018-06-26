package com.daniel.user.charleskeith.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.daniel.user.charleskeith.R;

public class Slider_Adapter extends PagerAdapter {
    public int[] slider_images = {R.drawable.shoe, R.drawable.shoe1, R.drawable.shoe, R.drawable.shoe1, R.drawable.shoe, R.drawable.shoe1};
    LayoutInflater layoutInflater;
    private Context context;

    public Slider_Adapter(Context context) {
        this.context = context;

    }

    @Override
    public int getCount() {
        return slider_images.length;
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
        sliderImageView.setImageResource(slider_images[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }
}
