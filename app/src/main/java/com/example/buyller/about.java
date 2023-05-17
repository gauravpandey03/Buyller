package com.example.buyller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class about extends AppCompatActivity {


    ImageView backarow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        backarow = findViewById(R.id.buyback);
    }

    public void change(View v) {
        // Start the destination activity or perform other actions
        Intent intent = new Intent(about.this, instagram.class);
        startActivity(intent);
    }


    public void arrowback(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void makeCall(View view) {
        String phoneNumber = "6387664293";
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        startActivity(intent);
    }

    public void composeEmail(View view) {
        String recipient = "buyller@gmail.com";
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:" + recipient));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Registration");

        startActivity(Intent.createChooser(intent, "Compose Email"));

    }




}