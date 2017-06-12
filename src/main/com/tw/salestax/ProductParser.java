package com.tw.salestax;

import java.util.ArrayList;

public class ProductParser {

    private final String REGEX = "[0-9.]";
    private final String AT = " at";
    Product product;

    private String[] products;

    private int quantity;
    private double price;
    private String productDetail;
    private ArrayList<Product> productsInBasket = new ArrayList<>();

    ProductParser(String[] inputProducts) {
        this.products = inputProducts;
        for (String inputProduct : inputProducts) {
            productsInBasket.add(parseProduct(inputProduct));
        }
    }

    private Product parseProduct(String inputProduct) {
        productDetail = inputProduct;
        String[] productDetails = inputProduct.split(" ");
        price = Double.parseDouble(productDetails[productDetails.length - 1]);
        quantity = Integer.parseInt(productDetails[0].trim());
        inputProduct = inputProduct.replaceAll(REGEX, "");
        productDetail = inputProduct.replaceAll(AT, "");
        productDetail = productDetail.trim();

        product = new Product(quantity, productDetail, price);
        product.findApplicableTax(new ProductCategorizer().categorizeProduct(product));

        return product;
    }

    public ArrayList<Product> getAllProductsInBasket() {
        return productsInBasket;
    }

}
