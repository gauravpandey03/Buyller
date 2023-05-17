package com.example.buyller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.cert.PKIXRevocationChecker;
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
    ArrayList<datamodel> userlist;

    //    List<datamodel> userlist;
    Adapter adapter;
    DatabaseReference myappdata;

//    https://firebasestorage.googleapis.com/v0/b/buyller-4715b.appspot.com/o/images%2F2023_05_17_19_55_31?alt=media&token=7b267b26-f498-4022-ad2c-e260d103f023


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_buy);
        back=findViewById(R.id.buyback);
//        initData();
        initRecyclerView();



    }

    private void initRecyclerView() {

        recyclerView = findViewById(R.id.recyclerView);
        myappdata = FirebaseDatabase.getInstance().getReference().child("maindata");
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        FirebaseRecyclerOptions<datamodel> options =
                new FirebaseRecyclerOptions.Builder<datamodel>()
                        .setQuery(myappdata, datamodel.class)
                        .build();


        recmargin marg = new recmargin(100);
        recyclerView.addItemDecoration(marg);


//        userlist = new ArrayList<>();
        // data base reference


        adapter = new Adapter(options);
        recyclerView.setAdapter(adapter);


//        myappdata.addValueEventListener(new ValueEventListener() {
//            @SuppressLint("NotifyDataSetChanged")
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
//                    datamodel tmp = dataSnapshot.getValue(datamodel.class);
////                    Log.d(tmp);
//                    userlist.add(tmp);
//
//                }
//                adapter.notifyDataSetChanged();
//
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//
//
//        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }


    private void initData() {
   userlist = new ArrayList<>();
   userlist.add(new datamodel("https://firebasestorage.googleapis.com/v0/b/buyller-4715b.appspot.com/o/images%2F2023_05_15_21_44_28?alt=media&token=13787f03-e995-4793-9dd0-2dc2836bf830"

                ,productName[0],productdetails[0],price[0],sellerphone[0],sellerdetails[0] ));
//        userlist.add(new datamodel(productimage[1],productName[1],productdetails[1],price[1],sellerphone[1],sellerdetails[1] ));
//        userlist.add(new datamodel(productimage[2],productName[2],productdetails[2],price[2],sellerphone[2],sellerdetails[2] ));


    }

    public void buyback(View view){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}