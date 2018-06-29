package com.daniel.user.charleskeith.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.daniel.user.charleskeith.CharlesAndKeithAPP;
import com.daniel.user.charleskeith.R;
import com.daniel.user.charleskeith.adapters.NewInAdapter;
import com.daniel.user.charleskeith.data.vo.ProductsVO;
import com.daniel.user.charleskeith.mvp.presenters.NewsInPresenter;
import com.daniel.user.charleskeith.mvp.views.NewInView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewInActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, NewInView {


    @BindView(R.id.item_count)
    TextView itemCount;
    private boolean HAS_ANOTHER_COLUMN = false;
    @BindView(R.id.tab_option_1)
    ImageButton mColumn1Button;
    @BindView(R.id.tab_option_2)
    ImageButton mColumn2Button;

    @BindView(R.id.new_in_rv)
    RecyclerView rvNewIn;

    private NewsInPresenter mPresenter;
    private NewInAdapter newInAdapter;

    private GridLayoutManager gridLayoutManager;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_new_in);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this, this);


        mPresenter = ViewModelProviders.of(this).get(NewsInPresenter.class);
        mPresenter.initPresenter(this);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        mPresenter.getProductsLD().observe(this, new Observer<List<ProductsVO>>() {
            @Override
            public void onChanged(@Nullable List<ProductsVO> productsVOS) {
                displayProducts(productsVOS);
                Log.d(CharlesAndKeithAPP.APP_LOG, "Livedata reached");
            }
        });
        mPresenter.getErrorLD().observe(this, this);


        gridLayoutManager = new GridLayoutManager(this, 2);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        newInAdapter = new NewInAdapter(getApplicationContext(), mPresenter, 1);


        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        mColumn1Button.setImageDrawable(getDrawable(R.drawable.column1_color));


        mColumn1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mColumn1Button.setImageDrawable(getDrawable(R.drawable.column1_color));
                mColumn2Button.setImageDrawable(getDrawable(R.drawable.column2));
                rvNewIn.setLayoutManager(linearLayoutManager);


            }
        });

        mColumn2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mColumn1Button.setImageDrawable(getDrawable(R.drawable.column1));
                mColumn2Button.setImageDrawable(getDrawable(R.drawable.column2_color));

                rvNewIn.setLayoutManager(gridLayoutManager);
//                newInAdapter = new NewInAdapter(getApplicationContext(), mPresenter ,2);


            }
        });

        rvNewIn.setLayoutManager(linearLayoutManager);
        rvNewIn.setAdapter(newInAdapter);
//        itemCount.setText(newInAdapter.getItemCount() + " ITEMS");
        Log.d(CharlesAndKeithAPP.APP_LOG, "Items np :" + newInAdapter.getItemCount());


    }

    @Override
    protected void onStart() {
        super.onStart();
        itemCount.setText(newInAdapter.getItemCount() + " ITEMS ");
        Log.d(CharlesAndKeithAPP.APP_LOG, "Items np from onStart:" + newInAdapter.getItemCount());
    }

    private void displayProducts(List<ProductsVO> productsVOS) {
        newInAdapter.appendNewData(productsVOS);

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.new_in, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.new_in) {

            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public Intent newIntent(Context context, String id) {
        Intent intent = new Intent(context, NewInDetailsActivity.class);
        intent.putExtra("id", id);
        return intent;
    }

    @Override
    public void launchItemDetailsScreen(String id) {
        Intent intent = newIntent(this, id);
        startActivity(intent);

    }


    @Override
    protected void onResume() {
        super.onResume();
//        List<ProductsVO> productsVO =  CKModel.getmInstance().getAllProduct();
//        displayProducts(productsVO);
    }

}
