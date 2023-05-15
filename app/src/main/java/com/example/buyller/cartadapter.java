package com.example.buyller;



import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class cartadapter extends RecyclerView.Adapter<cartadapter.ViewHolder> {

    private List<datamodel> userlist;

    public cartadapter(List<datamodel> userlist) {
        this.userlist = userlist;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cartview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String pimageadp = userlist.get(position).getPimage();
        String pnameadp = userlist.get(position).getPname();
        String priceadp = userlist.get(position).getPrice();
        String qunatity = userlist.get(position).getQuantity();


        holder.setData(pimageadp, pnameadp,priceadp);
    }

    @Override
    public int getItemCount() {
        return userlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView pnames;
        private TextView price;




        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pnames = (TextView) itemView.findViewById(R.id.pname);
            imageView = (ImageView) itemView.findViewById(R.id.pimage);
            price = (TextView) itemView.findViewById(R.id.price);


        }

        public void setData(String pimageadp, String pnameadp, String priceadp) {
            Uri uri = Uri.parse(pimageadp);
            imageView.setImageURI(uri);
            pnames.setText(pnameadp);
            price.setText(priceadp);


        }
    }
}


