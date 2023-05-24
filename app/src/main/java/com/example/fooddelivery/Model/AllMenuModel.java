package com.example.fooddelivery.Model;

import java.io.Serializable;

public class AllMenuModel implements Serializable {

    String img,name;
    int price;

    public AllMenuModel() {
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public AllMenuModel(String name, int price, String img) {
        this.name = name;
        this.price = price;
        this.img = img;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
