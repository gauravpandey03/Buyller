package com.example.buyller;


import static com.github.drjacky.imagepicker.ImagePicker.*;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.buyller.databinding.ActivityMainBinding;
import com.github.drjacky.imagepicker.ImagePicker;
import com.github.drjacky.imagepicker.constant.ImageProvider;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class sell extends AppCompatActivity {
    EditText pname,pdetails,price,sdetails,snumber;
    ImageView backarow,imgpkr;
    Button datainsert;
    private final int ReQUEST_CODE=1000;
    DatabaseReference buyllerdata;
    StorageReference imgdata;

    // other way to bind resources
//    ActivityMainBinding binding;
    Uri imageurl;
    ProgressDialog progressDialog;
    Uri image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
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
             uploadimage();
//             insertdata();

            }
        });
        imgpkr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                        Intent igal=new Intent(Intent.ACTION_PICK);
//                        igal.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                        startActivityForResult(igal,ReQUEST_CODE);
                selectimage();

            }
        });

    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(resultCode==RESULT_OK){
//        if(requestCode==ReQUEST_CODE){
//           imgpkr.setImageURI(data.getData());
//        }
//        }
//    }

    private  void selectimage(){
        Intent intent  = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,100);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==100 && data !=null && data.getData() != null){
            imageurl = data.getData();
            imgpkr.setImageURI(imageurl);
        }
    }

    private  void insertdata(){
        String prouductname = pname.getText().toString();
        String prodetails = pdetails.getText().toString();
        String pricetmp = price.getText().toString();
        String sdetailstmp = sdetails.getText().toString();
        String snumbertmp = snumber.getText().toString();

        if(prouductname != "" && prodetails != "" && pricetmp != "" && sdetailstmp != "" && snumbertmp != ""){

        datamodel maindata = new datamodel(image.toString(),prouductname,prodetails,pricetmp,sdetailstmp,snumbertmp);
        buyllerdata.push().setValue(maindata);
        Toast.makeText(this, "data inserted to database", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "please fill all the options!!", Toast.LENGTH_SHORT).show();
        }



    }
    private void uploadimage(){

        // first we will store the image in storage and then store a copy of that in the
        //real time database.

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Uploading file...");
        progressDialog.show();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.ENGLISH);
        Date now = new Date();
        String filename = formatter.format(now);
        imgdata = FirebaseStorage.getInstance().getReference("images/" + filename);
        imgdata.putFile(imageurl).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                imgpkr.setImageURI(null);
                imgpkr.setImageResource(R.drawable.ic_baseline_add_a_photo_24);
                Toast.makeText(sell.this, "image succesfully uploaded", Toast.LENGTH_SHORT).show();
                if(progressDialog.isShowing()){
                    progressDialog.dismiss();
                }
                imgdata.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        image = uri;
                        insertdata();
                        pname.setText("");
                        pdetails.setText("");
                        price.setText("");
                        sdetails.setText("");
                        snumber.setText("");
//                    buyllerdata.child("image").setValue(uri.toString()).addOnSuccessListener(new OnSuccessListener<Void>() {
//                        @Override
//                        public void onSuccess(Void unused) {
//                            Toast.makeText(sell.this, "image data added", Toast.LENGTH_SHORT).show();
//                        }
//                    });
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(sell.this, "failure images cannot be uploaded", Toast.LENGTH_SHORT).show();
                if(progressDialog.isShowing()){
                    progressDialog.dismiss();
                }

            }
        });


    }


    public void arrowback(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}