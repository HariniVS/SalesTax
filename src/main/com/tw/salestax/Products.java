package com.tw.salestax;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Products {

    private final int quantity;
    private final String productDescription;
    private final double price;

    Products(int quantity, String productDescription, double price) {
        this.quantity = quantity;
        this.productDescription = productDescription;
        this.price = price;
    }

    List<Products> products = new LinkedList<>();

    public void addProduct(Products productPurchased) {
        products.add(productPurchased);
    }

}
