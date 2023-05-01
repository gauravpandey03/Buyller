
package com.example.buyller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class sellpage extends  AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sellpage);
    }

    private void arrowback(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
