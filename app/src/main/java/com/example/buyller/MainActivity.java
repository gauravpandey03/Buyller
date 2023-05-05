package com.example.buyller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.filament.View;

public class MainActivity extends AppCompatActivity {
ImageView img1;
ImageView img2;
ImageView img3;
ImageView img4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1 = findViewById(R.id.extdes1);
        img4 = findViewById(R.id.extdes3);
        img3 = findViewById(R.id.extdes4);

        img2 = findViewById(R.id.extdes2);



    }

    public void buy(View view){
//        Toast.makeText(this, "buy page clicked", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this,buypage.class);
        startActivity(intent);

    }
    public void sell(View view){

        Intent intent = new Intent(this,sellpage.class);
        startActivity(intent);
    }
    public void aboutus(View view){

        Intent intent = new Intent(this,aboutpage.class);
        startActivity(intent);
    }
    public void query(View view){
        Toast.makeText(this, "this is query class", Toast.LENGTH_SHORT).show();

    }


}