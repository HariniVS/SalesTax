package com.tw.salestax;

public class ProductParser {
    private String[] products;
    private int quantity;
    private double price;
    private String productDetail;
    private Product[] productPurchased;
    private int productCount = 0 ;

    ProductParser(String[] products) {
        this.products = products;
        productPurchased = new Product[products.length];
        for (String product : products) {
            parseProduct(product);
        }
    }

    public void parseProduct(String product) {
        productDetail = product;
        String[] productDetails = product.split(" ");
        price = Double.parseDouble(productDetails[productDetails.length - 1]);
        quantity = Integer.parseInt(productDetails[0]);
        addNewProduct();
    }

    private void addNewProduct() {
        productPurchased[productCount] = new Product(quantity, productDetail, price);
        productPurchased[productCount].addProduct(productPurchased[productCount]);
        productCount++;
    }

    public Product[] getAllProductsInBasket() {
        return productPurchased;
    }
}
