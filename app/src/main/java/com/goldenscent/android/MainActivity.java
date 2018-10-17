package com.goldenscent.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.goldenscent.android.adapter.SideMenuAdapter;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMenuOptions;
    private SideMenuAdapter adapterSideMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
