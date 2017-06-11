package com.tw.salestax;

public class ProductParser {
    private int quantity;
    private String[] products;
    private String productDetail;
    private double price;

    ProductParser(String[] products) {
        this.products = products;
        for (String product : products) {
            parseProduct(product);
        }
    }

    public void parseProduct(String product) {
        productDetail = product;
        String[] productDetails = product.split(" ");
        price = Double.parseDouble(productDetails[productDetails.length - 1]);
        quantity = Integer.parseInt(productDetails[0]);
        Products productPurchased = new Products(quantity,productDetail,price);
        productPurchased.addProduct(productPurchased);
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getProduct() {
        return productDetail;
    }
}
