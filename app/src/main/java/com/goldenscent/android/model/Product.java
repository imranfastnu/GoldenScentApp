package com.goldenscent.android.model;

public class Product {

    public int imgResId;
    public String name;
    public String desc;
    public String price;
    public String priceDiscounted;

    public Product(int imgResId, String name, String desc, String price, String priceDiscounted) {
        this.imgResId = imgResId;
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.priceDiscounted = priceDiscounted;
    }

}
