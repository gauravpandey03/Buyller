package com.example.buyller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class sell extends AppCompatActivity {
    ImageView backarow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);
        backarow =findViewById(R.id.buyback);

    }
    public void arrowback(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}