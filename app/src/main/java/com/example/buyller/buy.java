package com.example.buyller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class buy extends AppCompatActivity {
    ImageView back;
        String productName[] = {"Drafter","mouse","keybboard","monitor"};
    // note the drawable images are take as integer form from the drawable directory ,, think some specific code for the images.
    int productimage[] = {R.drawable.drafter,R.drawable.mouse,R.drawable.keyboard,R.drawable.monitor};
    String productdetails [] = {"a ddrafet is used for some geometry making"," a mouse i used to move cursor in your pc","a key board is a hardware device used to type some"
            ,"a monitor is used to disply the processing "};
    String price[] = {"3434","43434","1111","56656"};
    String sellerphone[] = {"234234234","34234324","23423432","4545454"};
    String sellerdetails[] = {"Mohan singh bharka enterprise b street chok","bruce wayne  wayne enterprise new york","major contel other party unkonows place","holy moly main rpisdfsohter asdas"};

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<datamodel> userlist;
    Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
        back=findViewById(R.id.buyback);
        initData();
        initRecyclerView();



    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recmargin marg = new recmargin(100);
        recyclerView.addItemDecoration(marg);
        adapter = new Adapter(userlist);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();



    }

    private void initData() {
   userlist = new ArrayList<>();
   userlist.add(new datamodel(productimage[0],productName[0],productdetails[0],price[0],sellerphone[0],sellerdetails[0] ));
        userlist.add(new datamodel(productimage[1],productName[1],productdetails[1],price[1],sellerphone[1],sellerdetails[1] ));
        userlist.add(new datamodel(productimage[2],productName[2],productdetails[2],price[2],sellerphone[2],sellerdetails[2] ));


    }

    public void buyback(View view){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}