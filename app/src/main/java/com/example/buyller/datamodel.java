package com.example.buyller;

public class datamodel {

    private String pimage;
    private String pname;
    private String pdetails;
    private String pprice;
    private String snumber;
    private String sdetails;
    private  String totalprice;
    private  String Quantity;



    datamodel(){}
    datamodel(String pimage, String pname, String pdetails, String price, String snumber, String sdetails){
        this.pimage = pimage;
        this.pname = pname;
        this.pdetails = pdetails;
        this.pprice = price;
        this.snumber =  snumber;
        this.sdetails = sdetails;

    }
//    datamodel(String pname,String pdetails,String price,String sdetails,String snumber){
//        this.pname = pname;
//        this.pdetails = pdetails;
//        this.pprice = price;
//        this.sdetails = sdetails;
//        this.snumber = snumber;
//    }
//
//    datamodel(String pimage,String pname,String price){
//        this.pimage = pimage;
//        this.pname = pname;
//        this.pprice = price;
//    }

    public String getPimage() {
        return pimage;
    }



    public String getPname() {
        return pname;
    }



    public String getPdetails() {
        return pdetails;
    }


    public String getPrice() {
        return pprice;
    }



    public String getSnumber() {
        return snumber;
    }



    public String getSdetails() {
        return sdetails;
    }

    public String getTotalprice() {
        return totalprice;
    }
    public String getQuantity() {
        return Quantity;
    }

}
