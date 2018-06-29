package com.daniel.user.charleskeith.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daniel.user.charleskeith.R;
import com.daniel.user.charleskeith.adapters.NewInSuggestionAdapter;
import com.daniel.user.charleskeith.adapters.Slider_Adapter;
import com.daniel.user.charleskeith.data.vo.ProductsVO;
import com.daniel.user.charleskeith.mvp.presenters.NewInDetailsPresenter;
import com.daniel.user.charleskeith.mvp.views.NewInDetailsView;
import com.daniel.user.charleskeith.persistencec.dao.ProductsDB;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewInDetailsActivity extends AppCompatActivity implements NewInDetailsView {
    List<ProductsVO> productsVO;
    @BindView(R.id.item_details_name)
    TextView itemName;
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);
            if ((position) == mDots.length) {
                mItemSuggestions.setVisibility(View.VISIBLE);


            } else
                mItemSuggestions.setVisibility(View.GONE);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }

    };
    @BindView(R.id.item_details_image)
    ViewPager itemDetailsViewPager;
    TextView[] mDots;
    @BindView(R.id.item_detail_dots)
    LinearLayout mDotLayout;
    @BindView(R.id.item_details_suggestions)
    RecyclerView mItemSuggestions;
    @BindView(R.id.item_details_suggestions_pane)
    LinearLayout mSuggestionPane;
    NewInSuggestionAdapter newInAdapter;
    ActionBar actionBar;
    private String currentId;
    private NewInDetailsPresenter mPresenter;
    private Slider_Adapter sliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_in_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this, this);

        mPresenter = ViewModelProviders.of(this).get(NewInDetailsPresenter.class);
        mPresenter.initPresenter(this);
        currentId = getIntent().getStringExtra("id");
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setHomeAsUpIndicator(getDrawable(R.drawable.back_icon));
        actionBar.setTitle("NEW IN");

        productsVO = ProductsDB.getmInstance(getApplicationContext()).productDao().getProductById(currentId);

        sliderAdapter = new Slider_Adapter(this);
        itemDetailsViewPager.setAdapter(sliderAdapter);
        itemDetailsViewPager.addOnPageChangeListener(viewListener);
        mDotLayout.setPadding(5, 0, 5, 0);
        addDotsIndicator(0);
        mItemSuggestions.setVisibility(View.GONE);
        mItemSuggestions.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        newInAdapter = new NewInSuggestionAdapter(this);
        mItemSuggestions.setAdapter(newInAdapter);
        itemName.setText(productsVO.get(0).getProductTitle());


        mPresenter.getProductLDById(currentId).observe(this, new Observer<List<ProductsVO>>() {
            @Override
            public void onChanged(@Nullable List<ProductsVO> productsVOS) {
                sliderAdapter.setmProducts(productsVOS);
            }
        });

    }

    public void addDotsIndicator(int position) {


        mDots = new TextView[productsVO.size() + 1];


        mDotLayout.removeAllViews();

        for (int i = 0; i < mDots.length; i++) {

            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#9675;"));
            mDots[i].setTextSize(15);
//            mDots[i].setTextColor(getResources().getColor(R.color.colorPrimaryDark));

            mDotLayout.addView(mDots[i]);

        }


        if (mDots.length > 0) {
//            mDots[position].setTextColor(getResources().getColor(R.color.lightBlue));
            mDots[position].setText(Html.fromHtml("&#9679;"));
            mDots[position].setTextSize(20);
        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {

//            Intent intent = MainActivity.newIntent(this);
//            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
