package com.example.buyller;


import static com.github.drjacky.imagepicker.ImagePicker.*;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.drjacky.imagepicker.ImagePicker;
import com.github.drjacky.imagepicker.constant.ImageProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class sell extends AppCompatActivity {
    EditText pname,pdetails,price,sdetails,snumber;
    ImageView backarow,imgpkr;
    Button datainsert,p;
    private final int ReQUEST_CODE=1000;
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
        imgpkr=findViewById(R.id.imgpkr);
        // data base name
        buyllerdata = FirebaseDatabase.getInstance().getReference().child("maindata");
        datainsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             insertdata();
            }
        });
        imgpkr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        Intent igal=new Intent(Intent.ACTION_PICK);
                        igal.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(igal,ReQUEST_CODE);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
        if(requestCode==ReQUEST_CODE){
           imgpkr.setImageURI(data.getData());
        }
        }
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