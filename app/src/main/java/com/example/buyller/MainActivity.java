package com.example.buyller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ImageView img1;
ImageView img2;
ImageView img3;
ImageView img4,img5,img6,img7,img8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1 = findViewById(R.id.extdes1);
        img3 = findViewById(R.id.extdes3);
        img4 = findViewById(R.id.extdes4);

        img2 = findViewById(R.id.extdes2);

        img5 = findViewById(R.id.buydes);
        img6 = findViewById(R.id.selldes);
        img7 = findViewById(R.id.abourdes);

        img8 = findViewById(R.id.querydes);


    }

    public void buy(View view){
//        Toast.makeText(this, "buy page clicked", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this,buy.class);
        startActivity(intent);

    }
    public void sell(View view){

        Intent intent = new Intent(this,sell.class);
        startActivity(intent);
    }
    public void aboutus(View view){

        Intent intent = new Intent(this,about.class);
        startActivity(intent);
    }
    public void query(View view){
        Intent intent = new Intent(this,query_page.class);
        startActivity(intent);
    }


}