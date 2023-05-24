package com.example.fooddelivery.Model;

import androidx.recyclerview.widget.RecyclerView;

public class HistoryModel {

    String productDate;
    String productName;
    int productPrice;
    String productQuantity;
    String productTime;

    public HistoryModel() {
    }

    public HistoryModel(String productDate, String productName, int productPrice, String productQuantity, String productTime) {
        this.productDate = productDate;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productTime = productTime;
    }

    public String getProductDate() {
        return productDate;
    }

    public void setProductDate(String productDate) {
        this.productDate = productDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductTime() {
        return productTime;
    }

    public void setProductTime(String productTime) {
        this.productTime = productTime;
    }
}