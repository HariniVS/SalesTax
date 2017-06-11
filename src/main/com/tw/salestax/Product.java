package com.tw.salestax;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Product {

    private final int quantity;
    private final String productDescription;
    private final double price;

    Product(int quantity, String productDescription, double price) {
        this.quantity = quantity;
        this.productDescription = productDescription;
        this.price = price;
    }

    List<Product> products = new LinkedList<>();

    public void addProduct(Product productPurchased) {
        products.add(productPurchased);
    }

    public void categorizeAllProducts() {
        ProductCategorizer productCategorizer = new ProductCategorizer();
        Iterator<Product> productsIterator = products.iterator();
        while (productsIterator.hasNext() ) {
            productCategorizer.categorizeAllProducts(productsIterator.next());
        }
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
