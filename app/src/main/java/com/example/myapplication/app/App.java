package com.example.myapplication.app;

import android.app.Application;

import com.example.myapplication.database.AppDatabase;


//app launch hune bla ma kk kura haru run garnu prne xa tyo yehi aauxa

public class App extends Application {
    public static AppDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();
        initDb();
    }

    private void initDb() {
        db = AppDatabase.getInstance(getApplicationContext());
    }
}
