package ru.startandroid.lab02v2;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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

    public String TAG = "dLog";
    public String actName = "[0]ActivityMain";

    private DrawerLayout mDrawerLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d(TAG, actName + "::onCreate()");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mDrawerLayout = findViewById(R.id.drawer_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        final NavigationView navigationView = findViewById(R.id.nav_view);


        setSupportActionBar(toolbar); // Использовать toolbar как action bar
        ActionBar actionbar = getSupportActionBar();


        actionbar.setDisplayHomeAsUpEnabled(true); // Активируем кнопку "назад" в action bar
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu); // Меняем её иконку


        navigationView.setNavigationItemSelectedListener(
            new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem menuItem) {
                    menuItem.setChecked(true);

                    //mDrawerLayout.closeDrawers();

                    switch (menuItem.getItemId())
                    {
                        case R.id.nav_tables:
                            Intent intentTables = new Intent(getApplicationContext(), Tables.class);
                            startActivity(intentTables);
                            break;
                        case R.id.nav_elements_list:
                            Intent intentOpenElements = new Intent(getApplicationContext(), ElementsList.class);
                            startActivity(intentOpenElements);
                            break;
                        case R.id.nav_settings:
                            Intent intentOpenSettings = new Intent(getApplicationContext(), Settings.class);
                            startActivity(intentOpenSettings);
                            break;
                        case R.id.nav_about:
                            Intent intentOpenAbout = new Intent(getApplicationContext(), About.class);
                            startActivity(intentOpenAbout);
                            break;
                    }
                    return true;
                }
            });
    }



    @Override
    protected void onResume() {
        Log.d(TAG, actName + "::onResume()");

        super.onResume();
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }





}

/* TO DO
* * uncheck item selection в nav drawer сразу же после нажатия этой item
*
* * при нажатии UpButton в дочерней активности нужно ВЕРНУТЬСЯ И ПРОДОЛЖИТЬ выполнение родительской
* активности, вместо того, чтобы заново её создавать
*
*
*
* */