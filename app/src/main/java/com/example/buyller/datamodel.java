package com.example.buyller;

public class datamodel {

    private int pimage;
    private String pname;
    private String pdetails;
    private String pprice;
    private String snumber;
    private String sdetails;
    private  String totalprice;
    private  String Quantity;




    datamodel(int pimage, String pname, String pdetails, String price, String snumber, String sdetails){
        this.pimage = pimage;
        this.pname = pname;
        this.pdetails = pdetails;
        this.pprice = price;
        this.snumber =  snumber;
        this.sdetails = sdetails;

    }

    datamodel(int pimage,String pname,String price){
        this.pimage = pimage;
        this.pname = pname;
        this.pprice = price;
    }

    public int getPimage() {
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
