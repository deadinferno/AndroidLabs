package com.dead.lab02u;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "myLog";
    private DrawerLayout mDrawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "ACTIVITY::CALLBACK::START::onCreate()");

        super.onCreate(savedInstanceState);
        Log.d(TAG, "ACTIVITY::super.onCreate(savedInstanceState)");

        setContentView(R.layout.activity_main);
        Log.d(TAG, "ACTIVITY::setContentView(R.layout.activity_main)");

        // Navigation drawer
        Log.d(TAG, "ELEMENT::INIT::START::mDrawerLayout");
        mDrawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        Log.d(TAG, "ELEMENT::INIT::END::mDrawerLayout");

        // Toolbar
        Log.d(TAG, "ELEMENT::INIT::START::myToolbar");
        Toolbar myToolbar = findViewById(R.id.toolbar_main);
        Log.d(TAG, "ELEMENT::INIT::END::myToolbar");

        setSupportActionBar(myToolbar);
        Log.d(TAG, "ACTIVITY::setSupportActionBar(myToolbar)");

        Log.d(TAG, "ELEMENT::INIT::START::actionBar");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);

        // Navigation listener callback
        Log.d(TAG, "CALLBACK::SET::START::setNavigationItemSelectedListener()");
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();

                        return false;
                    }
                }
        );
        Log.d(TAG, "ACTIVITY::CALLBACK::END::onCreate()");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d(TAG, "ACTIVITY::CALLBACK::START::onCreateOptionsMenu()");
        getMenuInflater().inflate(R.menu.toolbar_view, menu);
        Log.d(TAG, "ACTIVITY::CALLBACK::END::onCreateOptionsMenu()");
        return true;
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
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId())
        {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
