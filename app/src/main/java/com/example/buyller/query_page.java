package com.example.buyller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class query_page extends AppCompatActivity {
    ImageView send;
    EditText msg;
    DatabaseReference query;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_page);
        send=findViewById(R.id.send);
        msg=findViewById(R.id.msg);
        query= FirebaseDatabase.getInstance().getReference().child("query");
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                query.push().setValue(msg.getText().toString());
                Toast.makeText(getApplicationContext(),"message sent",Toast.LENGTH_SHORT).show();
            }
        });
    }
}