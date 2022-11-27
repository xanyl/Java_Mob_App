package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.adapter.ProductAdapter;
import com.example.myapplication.models.Product;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {
     private RecyclerView rvProduct;
    private ArrayList<Product> productArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        rvProduct = findViewById(R.id.rvProduct);
        initData();
    }

    private  void initData(){
        Product product1 = new Product();
        product1.setId(1);
        product1.setCategory("Laptop");
        product1.setPrice(1500.00);
        product1.setName("macbook air 13 Inch");


        Product product2 = new Product();
        product2.setId(2);
        product2.setCategory("Mobile");
        product2.setPrice(500.00);
        product2.setName("iphone 13 pro");

        Product product3 = new Product();
        product3.setId(3);
        product3.setCategory("Clothes");
        product3.setPrice(150.00);
        product3.setName("Hoodie");

        Product product4 = new Product();
        product4.setId(4);
        product4.setCategory("Clothes");
        product4.setPrice(100.00);
        product4.setName("Shirt");

        Product product5 = new Product();
        product4.setId(4);
        product4.setCategory("Clothes");
        product4.setPrice(1000.00);
        product4.setName("TShirt");


        ArrayList<Product> productArrayList = new ArrayList<>();
        productArrayList.add(product1);
        productArrayList.add(product2);
        productArrayList.add(product3);
        productArrayList.add(product4);
        productArrayList.add(product5);
        ProductAdapter adapter = new ProductAdapter(ProductActivity.this,this.productArrayList);
        rvProduct.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rvProduct.setAdapter(adapter);
    }
}