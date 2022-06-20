package com.example.online_auction;


public class Auction {
    private String Auction_name;
    private String Description;
    private String Hostname;
    private String Date;
    private String Category;


    public Auction(){

    }
    public Auction(String auction_name,String description,String hostname,String date,String category){
        Auction_name = auction_name;
        Description = description;
        Hostname = hostname;
        Date = date;
        Category = category;

    }



    public String getAuction_name() {
        return Auction_name;
    }

    public void setAuction_name(String auction_name) {
        Auction_name = auction_name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getHostname() {
        return Hostname;
    }

    public void setHostname(String hostname) {
        Hostname = hostname;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }
}
