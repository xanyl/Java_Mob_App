package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin,btnSignup;
    private  String username, password;
    private EditText etUsername, etPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(meroValidation()){
                   Intent i = new Intent(
                           LoginActivity.this,
                           DashboardActivity.class
                   );
                   startActivity(i);
               }
               else{
                   Toast.makeText(LoginActivity.this, "Please enter the correct details", Toast.LENGTH_SHORT).show();
               }
            }
        });
        btnSignup = findViewById(R.id.btnSignup);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
//                finish(); // Destroy the login page
            }
        }) ;
    }

    private boolean meroValidation() {
        username = etUsername.getText().toString();

        password = etPassword.getText().toString();
        if (username.isEmpty()) {
            etUsername.setError("Username cannot be empty");
            return false;
        }

        if (password.isEmpty()) {
            etPassword.setError("Password cannot be empty");
            return false;
        }
        return true;
    }
}