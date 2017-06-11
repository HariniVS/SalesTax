package com.tw.salestax;

import java.util.LinkedList;
import java.util.List;

public class Product {

    private int quantity;
    private String productDescription;
    private double price;

    private ProductCategorizer productCategorizer = new ProductCategorizer();

    Product(int quantity, String productDescription, double price) {
        this.quantity = quantity;
        this.productDescription = productDescription;
        this.price = price;
    }

    List<Product> products = new LinkedList<>();

    public void addProduct(Product productPurchased) {
        products.add(productPurchased);
        productCategorizer.categorizeProduct(productPurchased);
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getProductDescription() {
        return productDescription;
    }
}
