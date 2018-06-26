package com.daniel.user.charleskeith.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.daniel.user.charleskeith.R;
import com.daniel.user.charleskeith.adapters.NewInAdapter;
import com.daniel.user.charleskeith.adapters.NewInAdapterColumn2;
import com.daniel.user.charleskeith.mvp.presenters.NewsInPresenter;
import com.daniel.user.charleskeith.mvp.views.NewInView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewInActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, NewInView {

    @BindView(R.id.tab_option_1)
    ImageButton mColumn1Button;

    @BindView(R.id.tab_option_2)
    ImageButton mColumn2Button;
    @BindView(R.id.new_in_rv)
    RecyclerView rvNewIn;
    private int COLUMN_COUNT = 1;
    private NewsInPresenter mPresenter;
    private NewInAdapter newInAdapter;
    private NewInAdapterColumn2 newInAdapterColumn2;
    private GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_in);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this, this);

        mPresenter = new NewsInPresenter(this);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        gridLayoutManager = new GridLayoutManager(this, 2);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        mColumn1Button.setImageDrawable(getDrawable(R.drawable.column1_color));


        mColumn1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (COLUMN_COUNT == 2) {
                    COLUMN_COUNT = 1;
                }
                mColumn1Button.setImageDrawable(getDrawable(R.drawable.column1_color));
                mColumn2Button.setImageDrawable(getDrawable(R.drawable.column2));
                onStart();

            }
        });

        mColumn2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (COLUMN_COUNT == 1) {
                    COLUMN_COUNT = 2;
                }
                mColumn1Button.setImageDrawable(getDrawable(R.drawable.column1));
                mColumn2Button.setImageDrawable(getDrawable(R.drawable.column2_color));
                onStart();

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (COLUMN_COUNT == 2) {
            rvNewIn.setLayoutManager(gridLayoutManager);
            newInAdapterColumn2 = new NewInAdapterColumn2(this, mPresenter);
            rvNewIn.setAdapter(newInAdapterColumn2);

        } else {
            rvNewIn.setLayoutManager(new LinearLayoutManager(this));
            newInAdapter = new NewInAdapter(this, mPresenter);
            rvNewIn.setAdapter(newInAdapter);
        }
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

    public Intent newIntent(Context context) {
        Intent intent = new Intent(context, NewInDetailsActivity.class);
        return intent;
    }

    @Override
    public void launchItemDetailsScreen() {
        Intent intent = newIntent(this);
        startActivity(intent);

    }
}
