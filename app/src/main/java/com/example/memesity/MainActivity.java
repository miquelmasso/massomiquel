package com.example.memesity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SystemClock.sleep(200);
        setTheme(R.style.Theme_Memesity);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Button btnSignIn = findViewById(R.id.btnSignIn);
        EditText txtUsername = findViewById(R.id.txtUsername);
        EditText txtPassword = findViewById(R.id.txtPassword);



        btnSignIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                if(txtUsername.getText().toString().equals("123") && txtPassword.getText().toString().equals("123")){
                    startActivity(new Intent(getApplicationContext(),MainMenu.class));
                    Log.i("test","hola he fet click"); //comprobation of the click
                }
            }
        });
    }


}