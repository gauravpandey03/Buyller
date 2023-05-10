package com.example.buyller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<datamodel> userlist;

    public Adapter(List<datamodel> userlist) {
        this.userlist = userlist;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int pimageadp = userlist.get(position).getPimage();
        String pnameadp = userlist.get(position).getPname();
        String pdetailsadp = userlist.get(position).getPdetails();
        String priceadp = userlist.get(position).getPrice();
        String sellerphoneadp = userlist.get(position).getSnumber();
        String sdetailsadp = userlist.get(position).getSdetails();

        holder.setData(pimageadp, pnameadp, pdetailsadp, priceadp, sellerphoneadp, sdetailsadp);
    }

    @Override
    public int getItemCount() {
        return userlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView pnames;
        private TextView pdetail;
        private TextView prices;
        private TextView snumber;
        private TextView sdetail;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pnames = (TextView) itemView.findViewById(R.id.pname);
            imageView = (ImageView) itemView.findViewById(R.id.pimage);
            pdetail = (TextView) itemView.findViewById(R.id.pdetails);
            prices = (TextView) itemView.findViewById(R.id.price);
            snumber = (TextView) itemView.findViewById(R.id.snumber);
            sdetail = (TextView) itemView.findViewById(R.id.sdetails);
        }

        public void setData(int pimageadp, String pnameadp, String pdetailsadp, String priceadp, String sellerphoneadp, String sdetailsadp) {
            imageView.setImageResource(pimageadp);
            pnames.setText(pnameadp);
            pdetail.setText(pdetailsadp);
            prices.setText(priceadp);
            snumber.setText(sellerphoneadp);
            sdetail.setText(sdetailsadp);

        }
    }
}

//    public static class datamodel {
//        private int pimage;
//        private String pname;
//        private  String pdetails;
//
//        private  int pprice ;
//        private  String snumber;
//        private  String sdetails;
//
//        datamodel (int pimage,String pname,String pdetails,int pprice,String snumber,String sdetails){
//
//            this.pimage = pimage;
//            this.pname = pname;
//            this.pdetails = pdetails;
//            this.pprice = pprice;
//            this.snumber = snumber;
//            this.sdetails = sdetails;
//
//        }
//
//
//        public int getPimage() {
//            return pimage;
//        }
//
//
//
//        public String getPname() {
//            return pname;
//        }
//
//
//
//        public String getPdetails() {
//            return pdetails;
//        }
//
//
//
//        public int getPprice() {
//            return pprice;
//        }
//
//
//
//        public String getSnumber() {
//            return snumber;
//        }
//
//
//
//        public String getSdetails() {
//            return sdetails;
//        }
//
//
//    }
//}

