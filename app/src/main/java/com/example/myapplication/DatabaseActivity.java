package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.app.App;
import com.example.myapplication.database.AppDatabase;
import com.example.myapplication.database.dao.FoodDao;
import com.example.myapplication.database.model.FoodEntity;

public class DatabaseActivity extends AppCompatActivity {
    private AppDatabase db;
    private FoodDao foodDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        db = App.db;
        foodDao = db.foodDao();

        FoodEntity food1 = new FoodEntity();
        food1.setName("Burger");
        food1.setFood_id(23);
        food1.setPrice("250");
        food1.setStatus("Available");

        //inserting data into database
//        foodDao.insertItem(food1);
        foodDao.deleteItem(food1);
        Log.d("TEST_FOOD","DB Record Size ==>"+ foodDao.getAllItems().size());
    }
}