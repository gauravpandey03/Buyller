package com.example.buyller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.filament.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void buy(View v){

    }
    public void sell(View v){
        Intent intent = new Intent(this,sellpage.class);
        startActivity(intent);
    }
    public void aboutus(View v){
        Intent intent = new Intent(this,aboutpage.class);
        startActivity(intent);
    }
    public void query(View v){


    }
}