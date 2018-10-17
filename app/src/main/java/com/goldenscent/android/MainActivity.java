package com.goldenscent.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.goldenscent.android.adapter.SideMenuAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMenuOptions;
    private SideMenuAdapter adapterSideMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMenuOptions = (RecyclerView)findViewById(R.id.rvMenuOptions);
        setupMenuRecyclerView();

        HomeFragment homeFragment = HomeFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, homeFragment)
                .commit();

    }

    private void setupMenuRecyclerView() {

        adapterSideMenu = new SideMenuAdapter(this);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvMenuOptions.setLayoutManager(mLayoutManager);
        rvMenuOptions.setHasFixedSize(true);
        rvMenuOptions.setNestedScrollingEnabled(false);
        rvMenuOptions.setItemAnimator(new DefaultItemAnimator());
        rvMenuOptions.setAdapter(adapterSideMenu);
        adapterSideMenu.setRecyclerView(rvMenuOptions);
    }

}
