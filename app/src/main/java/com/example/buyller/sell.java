package com.example.buyller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class sell extends AppCompatActivity {
    EditText pname,pdetails,price,sdetails,snumber;
    ImageView backarow;
    Button datainsert;

    DatabaseReference buyllerdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);
        backarow =findViewById(R.id.buyback);
        pname = findViewById(R.id.pnameentry);
        pdetails = findViewById(R.id.pdetailsentry);
        price = findViewById(R.id.priceentry);
        sdetails = findViewById(R.id.sdetailsentry);
        snumber = findViewById(R.id.sellerpentry);
        datainsert = findViewById(R.id.databasesubmit);
        // data base name
        buyllerdata = FirebaseDatabase.getInstance().getReference().child("maindata");
        datainsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             insertdata();
            }
        });

    }
    private  void insertdata(){
        String prouductname = pname.getText().toString();
        String prodetails = pdetails.getText().toString();
        String pricetmp = price.getText().toString();
        String sdetailstmp = sdetails.getText().toString();
        String snumbertmp = snumber.getText().toString();

        datamodel maindata = new datamodel(prouductname,prodetails,pricetmp,sdetailstmp,snumbertmp);
        buyllerdata.push().setValue(maindata);
        Toast.makeText(this, "data inserted to database", Toast.LENGTH_SHORT).show();


    }
    public void arrowback(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}