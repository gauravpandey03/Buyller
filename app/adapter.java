

package com.example.buyller;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class adapter extends ArrayAdapter<String> {

    private  String [] Productname;
    private  String [] productdetails;
    private int[] price;
    private String [] phonenumber;
    private String[] sellerdetials;

    private Context context;



    // you can create different type of constructirs using android studio itself
    public Customadapterr(@NonNull Context context,
                          int resource,
                          @NonNull  String[] pname,
                          String[] pdetails,
                          int[] pprice,
                          String[] sellerphone,
                          String[] sellerdetails) {
        super(context, resource, pname,pdetails,pprice,sellerphone,sellerdetails);
        this.Productname  = pname;
        this.productdetails = pdetails;
        this.price = pprice;
        this.phonenumber =sellerphone;
        this.sellerdetials = sellerdetails;
        this.context = context;
    }

    @Nullable
    @Override
    public String getItem(int position) {
//        returning the index
        return Productname[position];
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        inflating layout
//        setting the new made view my_layout as inflat so that we can use the properties
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.card,parent,false);
        TextView pname =  convertView.findViewById(R.id.pname);
        pname.setText(getItem(position));
        TextView pdetails =  convertView.findViewById(R.id.pdetails);
        pdetails.setText(getItem(position));
        TextView price =  convertView.findViewById(R.id.price);
        price.setText(getItem(position));
        TextView snumber =  convertView.findViewById(R.id.snumber);
        snumber.setText(getItem(position));
        TextView sdetails =  convertView.findViewById(R.id.sdetails);
        sdetails.setText(getItem(position));


//       if the custom adpater click view listener doesnt work then do the below code
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "this is item " + position, Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }
}

