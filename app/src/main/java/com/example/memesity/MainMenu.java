package com.example.memesity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.graphics.drawable.shapes.Shape;


import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomePrincipal()).commit();


        BottomNavigationView bottomNav = findViewById(R.id.main_menu);

        bottomNav.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            switch (item.getItemId()){
                case R.id.nav_home:
                    selectedFragment = new HomePrincipal();
                    break;
                case R.id.nav_search:
                    selectedFragment = new Busca();
                    break;
                case R.id.nav_post:
                    selectedFragment = new Post();
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
}