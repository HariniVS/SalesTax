package com.tw.salestax;

public class Product {

    private int quantity;
    private String productDescription;
    private double price;
    private double taxAppliedPrice;

    private Tax tax;

    Product(int quantity, String productDescription, double price) {
        this.quantity = quantity;
        this.productDescription = productDescription;
        this.price = price;
    }

    @Override
    public boolean equals(Object object) {
        Product product = (Product) object;
        return product.getQuantity() == quantity && product.getPrice() ==
                price && product.getProductDescription().equals(productDescription);
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

    public double getTaxAppliedPrice() {
        return taxAppliedPrice;
    }

    public void findApplicableTax(Tax tax) {
        this.tax = tax;
        applyTax();
    }

    private void applyTax() {
        taxAppliedPrice = quantity * (price + (tax.getTaxPercentageFactor() *
                price));
    }

    public double getTax() {
        return quantity * tax.getTaxPercentageFactor() * price;
    }

}
