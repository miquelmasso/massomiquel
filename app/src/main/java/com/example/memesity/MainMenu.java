package com.example.memesity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;


import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;

import com.example.memesity.DB.MemesDBHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Locale;

public class MainMenu extends AppCompatActivity {
    //Create the instance of dbHelper
    private MemesDBHelper dbHelper;
    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomePrincipal(dbHelper, db)).commit();

        //Creation of the dbHelper
        dbHelper = new MemesDBHelper(getApplicationContext());
        db = dbHelper.getWritableDatabase();

        BottomNavigationView bottomNav = findViewById(R.id.main_menu);

        bottomNav.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            switch (item.getItemId()){
                case R.id.nav_home:
                    selectedFragment = new HomePrincipal(dbHelper, db);
                    break;
                case R.id.nav_search:
                    selectedFragment = new Busca();
                    break;
                case R.id.nav_post:
                    selectedFragment = new Post(dbHelper, db);
                    break;
                case R.id.nav_notifications:
                    selectedFragment = new Notificacions();
                    break;
                case R.id.nav_person:
                    selectedFragment = new Perfil();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        });

    }
    void setAppLocale(String localeCode){
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration config = res.getConfiguration();

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN_MR1){
            config.setLocale(new Locale(localeCode.toLowerCase()));
        } else {
            config.locale = new Locale(localeCode.toLowerCase());
        }
        res.updateConfiguration(config, dm);
    }

    //Close the db when the activity onDestroy
    @Override
    protected void onDestroy() {
        dbHelper.close();
        db.close();
        super.onDestroy();
    }
}