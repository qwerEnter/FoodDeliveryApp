package com.example.fooddelivery.Model;

public class DinnerModel {
    String name;

    String img;


    public DinnerModel() {
    }

    public DinnerModel(String name,  String img) {
        this.name = name;

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
