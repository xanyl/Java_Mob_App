package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myapplication.adapter.FoodEntityAdapter;
import com.example.myapplication.app.App;
import com.example.myapplication.database.model.FoodEntity;
import com.example.myapplication.databinding.ActivityDatabaseBinding;

import java.util.ArrayList;

public class DatabaseActivity extends AppCompatActivity {

    private ActivityDatabaseBinding binding;
    private ArrayList<FoodEntity> foodEntityArrayList = new ArrayList<>(); //model/pojo/dao(ArrayList)
    private FoodEntityAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDatabaseBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        setAppBar();

        binding.btnAddRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DatabaseActivity.this, AddRecordActivity.class);
                startActivity(intent);
            }
        });
        binding.rvRecords.setLayoutManager(new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL,
                false
        ));
        foodEntityArrayList.addAll(App.foodDao.getAllItems());

        adapter = new FoodEntityAdapter(DatabaseActivity.this, foodEntityArrayList);
        binding.rvRecords.setAdapter(adapter);


        binding.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                App.foodDao.deleteAll();
            }
        });
    }
    private void setAppBar() {
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setTitle(R.string.txtAllFood);
        }
}
    @Override
    protected void onResume() {
        super.onResume();
        adapter.update((ArrayList<FoodEntity>) App.foodDao.getAllItems());
    }
}