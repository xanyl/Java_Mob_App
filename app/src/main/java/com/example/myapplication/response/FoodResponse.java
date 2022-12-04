package com.example.myapplication.response;

import com.example.myapplication.models.Food;

import java.util.ArrayList;
//response class use for parsing
public class FoodResponse {
    private boolean success;
    private String message;
    private ArrayList<Food> data;    //json ma j xa api ko tyai rakhne ani array list ma array list

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Food> getData() {
        return data;
    }

    public void setData(ArrayList<Food> data) {
        this.data = data;
    }
}
