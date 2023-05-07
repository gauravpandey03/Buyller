package com.example.buyller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class buy extends AppCompatActivity {
    ImageView back;
    //    String productName[] = {"Drafter","mouse","keybboard","monitor"};
//    // note the drawable images are take as integer form from the drawable directory ,, think some specific code for the images.
//    int productimage[] = {R.drawable.drafter,R.drawable.mouse,R.drawable.keyboard,R.drawable.monitor};
//    String productdetails [] = {"a ddrafet is used for some geometry making"," a mouse i used to move cursor in your pc","a key board is a hardware device used to type some" +
//            "thing in your pc","a monitor is used to disply the processing "};
//    int price[] = {1000,2000,0202,0343};
//    String sellerphone[] = {"234234234","34234324","23423432","$%4545454"};
//    String sellerdetails[] = {"Mohan singh\n bharka enterprise\n b street chok","bruce wayne \n wayne enterprise\n new york","major contel\n other party\n unkonows place","holy moly\n main rpisdfs\nohter asdas"};
//
////    RecyclerView recyclerView;
//        ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
        back=findViewById(R.id.buyback);
        //        listView = (ListView) findViewById(R.id.customlistview);
//        Customadapter customadapter  = new Customadapter(getApplicationContext(),productName,productimage,productdetails,price,sellerphone,sellerdetails);
//        listView.setAdapter(customadapter);
    }
    public void arrowback(View view){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}