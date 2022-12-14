package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myapplication.databinding.ActivityDatabaseBinding;

public class DatabaseActivity extends AppCompatActivity {
    private ActivityDatabaseBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDatabaseBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        binding.btnAddRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DatabaseActivity.this, AddRecordActivity.class);
                startActivity(intent);
            }
        });
        binding.rvRecords.setLayoutManager(new LinearLayoutManager(
                this,LinearLayoutManager.VERTICAL,
                false
        ));

        binding.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DatabaseActivity.this, "Delete Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}