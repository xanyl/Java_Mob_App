package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    private  String username, fullname, email, password;
    private EditText etUsername, etFullname, etEmail, etPassword;
    private Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        //Variable name = findViewById(ID of View.xml file)
        etUsername = findViewById(R.id.etUsername);
        etFullname = findViewById(R.id.etFullname);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);


        btnSignup = findViewById(R.id.btnSignup);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (meroValidation()) {
                    Intent intent  = new Intent(SignupActivity.this, LoginActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(SignupActivity.this, "Please enter the correct details", Toast.LENGTH_SHORT).show();
                }
            }
        });
    setAppBar();

    }
    private void  setAppBar(){
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }
    }

    private boolean meroValidation() {
        username = etUsername.getText().toString();
        fullname = etFullname.getText().toString();
        email = etFullname.getText().toString();
        password = etPassword.getText().toString();
        if (username.isEmpty()) {
            etUsername.setError("Username cannot be empty");
            return false;
        }
        if (fullname.isEmpty()) {
            etFullname.setError("FullName cannot be empty");
            return false;
        }
        if (email.isEmpty()) {
            etEmail.setError("Email cannot be empty");
            return false;
        }
        if (password.isEmpty()) {
            etPassword.setError("Password cannot be empty");
            return false;
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);

    }
}