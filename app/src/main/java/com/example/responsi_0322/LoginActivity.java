package com.example.responsi_0322;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button btn_login;

    private SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.unem);
        password = findViewById(R.id.password);
        btn_login = findViewById(R.id.login);

        login();

        if(SharedPref.getInstance(LoginActivity.this).isLogin()){
            startActivity(new Intent(this, LoginActivity.class));
        }
    }

    public void login(){
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = username.getText().toString();
                String pass = password.getText().toString();

                if (name.equals("admin") && pass.equals("admin")) {
                    Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                    SharedPref.getInstance(LoginActivity.this).setName(name);
                    SharedPref.getInstance(LoginActivity.this).setLogin(true);

                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}