package com.example.memesity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;
import java.util.concurrent.Executor;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SystemClock.sleep(300);
        setTheme(R.style.Theme_Memesity);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Button btnSignIn = findViewById(R.id.btnSignIn);
        EditText txtUsername = findViewById(R.id.txtUsername);
        EditText txtPassword = findViewById(R.id.txtPassword);


        SharedPreferences prefs= getSharedPreferences("SharedP", Context.MODE_PRIVATE);
        SharedPreferences.Editor sharededitor = prefs.edit();

        if(prefs.getBoolean("login", false)==true){
            startActivity(new Intent(getApplicationContext(),MainMenu.class));

        }

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                if(txtUsername.getText().toString().equals("123") && txtPassword.getText().toString().equals("123")){
                    sharededitor.putBoolean("login", true).commit();

                    startActivity(new Intent(getApplicationContext(),MainMenu.class));
                }
                else {
                    Toast.makeText(getApplicationContext(), "Contraseña incorrecta", Toast.LENGTH_LONG).show();
                    txtPassword.setText("");
                }
            }
        });
    }




}