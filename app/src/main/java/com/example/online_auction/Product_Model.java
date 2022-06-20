package com.example.online_auction;

public class Product_Model {

    private String Product_name ;
    private String Product_description;
    private String Min_bid ;
    private String Date_product ;
    private String Category_product;

    public Product_Model(){

    }

    public Product_Model(String product_name,String product_description,String min_bid,String date_product,String category_product){
        Product_name = product_name;
        Product_description = product_description;
        Min_bid = min_bid;
        Date_product = date_product;
        Category_product = category_product;
    }



    public String getProduct_name() {
        return Product_name;
    }

    public void setProduct_name(String product_name) {
        Product_name = product_name;
    }

    public String getProduct_description() {
        return Product_description;
    }

    public void setProduct_description(String product_description) {
        Product_description = product_description;
    }

    public String getMin_bid() {
        return Min_bid;
    }

    public void setMin_bid(String min_bid) {
        Min_bid = min_bid;
    }

    public String getDate_product() {
        return Date_product;
    }

    public void setDate_product(String date_product) {
        Date_product = date_product;
    }

    public String getCategory_product() {
        return Category_product;
    }

    public void setCategory_product(String category_product) {
        Category_product = category_product;
    }
}
