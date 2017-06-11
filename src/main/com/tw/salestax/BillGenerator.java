package com.tw.salestax;

import java.util.Map;

public class BillGenerator {

    private double billAmount = 0.0;
    private double salesTax = 0.0;

    public void generateBill(Map<Product, Tax> allTheProductsInTheBasket) {
        for (Map.Entry<Product, Tax> mapEntry : allTheProductsInTheBasket.entrySet()) {
            Product product = mapEntry.getKey();
            Tax taxValue = mapEntry.getValue();
            double taxAppliedPrice = (taxValue.applyTax() * product.getPrice() + product.getPrice());
            billAmount = billAmount + (double)(taxAppliedPrice * product.getQuantity());
            if (taxValue instanceof SalesTax) {
                salesTax += taxAppliedPrice - product.getPrice();
            }
        }
        billAmount = Math.ceil(billAmount * 100.0) / 100.0;
        salesTax = Math.ceil(salesTax * 100.0) / 100.0;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public double getSalesTaxAmount() {
        return salesTax;
    }

}
