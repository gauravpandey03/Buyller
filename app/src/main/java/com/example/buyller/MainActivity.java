package com.example.buyller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.filament.View;

public class MainActivity extends AppCompatActivity {

    public void buy(View view){
        Toast.makeText(this, "buy page clicked", Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(this,buypage.class);
//        startActivity(intent);

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}