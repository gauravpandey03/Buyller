package com.example.buyller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class cartpage extends AppCompatActivity {
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartpage);

    }

    public void cartback(View view){
        Intent intent = new Intent(this,buy.class);
        startActivity(intent);
    }
}