package com.example.buyller;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends FirebaseRecyclerAdapter<datamodel,Adapter.myviewholder>{
    public Adapter(@NonNull FirebaseRecyclerOptions<datamodel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull datamodel model) {

            holder.pnames.setText(model.getPname());
    holder.pdetail.setText(model.getPdetails());
    holder.prices.setText(model.getPrice());
    holder.snumber.setText(model.getSnumber());
    holder.sdetail.setText(model.getSdetails());
        Glide.with(holder.imageView.getContext()).load(model.getPimage()).into(holder.imageView);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardview,parent,false);
        return  new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView pnames;
        private TextView pdetail;
        private TextView prices;
        private TextView snumber;
        private TextView sdetail;
        public ImageButton btn;


        public myviewholder(@NonNull View itemView) {
            super(itemView);
            pnames = (TextView) itemView.findViewById(R.id.pname);
            imageView = (ImageView) itemView.findViewById(R.id.pimage);
            pdetail = (TextView) itemView.findViewById(R.id.pdetails);
            prices = (TextView) itemView.findViewById(R.id.price);
            snumber = (TextView) itemView.findViewById(R.id.snumber);
            sdetail = (TextView) itemView.findViewById(R.id.sdetails);
//            btn =  itemView.findViewById(R.id.cartbtn);
//            btn.setOnClickListener((View.OnClickListener) this);


        }
    }

}
// this method deosnt work correctly so....

//public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
//
//    ArrayList<datamodel> userlist;
//    Context context;
//    public Adapter(Context context,ArrayList<datamodel> list){
//        this.context = context;
//        this.userlist = list;
//
//    }
//
//
//
//
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardview, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        String pimageadp = userlist.get(position).getPimage();
//        String pnameadp = userlist.get(position).getPname();
//        String pdetailsadp = userlist.get(position).getPdetails();
//        String priceadp = userlist.get(position).getPrice();
//        String sellerphoneadp = userlist.get(position).getSnumber();
//        String sdetailsadp = userlist.get(position).getSdetails();
//
//        holder.setData(pimageadp, pnameadp, pdetailsadp, priceadp, sellerphoneadp, sdetailsadp);
////    datamodel data = userlist.get(position);
////    holder.pnames.setText(data.getPname());
////        Uri myuri = Uri.parse(data.getPimage());
////
////    holder.imageView.setImageURI(myuri);
////    holder.pdetail.setText(data.getPdetails());
////    holder.prices.setText(data.getPrice());
////    holder.snumber.setText(data.getSnumber());
////    holder.sdetail.setText(data.getSdetails());
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return userlist.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        private ImageView imageView;
//        private TextView pnames;
//        private TextView pdetail;
//        private TextView prices;
//        private TextView snumber;
//        private TextView sdetail;
//
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            pnames = (TextView) itemView.findViewById(R.id.pname);
//            imageView = (ImageView) itemView.findViewById(R.id.pimage);
//            pdetail = (TextView) itemView.findViewById(R.id.pdetails);
//            prices = (TextView) itemView.findViewById(R.id.price);
//            snumber = (TextView) itemView.findViewById(R.id.snumber);
//            sdetail = (TextView) itemView.findViewById(R.id.sdetails);
//        }
//
//        public void setData(String pimageadp, String pnameadp, String pdetailsadp, String priceadp, String sellerphoneadp, String sdetailsadp) {
//            Uri myuri = Uri.parse(pimageadp);
//            imageView.setImageURI(myuri);
//            pnames.setText(pnameadp);
//            pdetail.setText(pdetailsadp);
//            prices.setText(priceadp);
//            snumber.setText(sellerphoneadp);
//            sdetail.setText(sdetailsadp);
//
//        }
//    }
//}


