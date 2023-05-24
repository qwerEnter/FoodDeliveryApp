package com.example.fooddelivery.Model;

public class RecommendModel {

    String name;
    String desc;
    String img;

    public RecommendModel() {
    }

    public RecommendModel(String name, String desc, String img) {
        this.name = name;
        this.desc = desc;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
