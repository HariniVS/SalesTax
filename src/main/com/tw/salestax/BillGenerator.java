package com.tw.salestax;

import java.util.ArrayList;
import java.util.Iterator;

public class BillGenerator {

    public static final String TOTAL = "Total - ";
    public static final String SALES_TAXES = "Sales Taxes - ";
    private double billAmount = 0.0;
    private double salesTax = 0.0;
    private ArrayList<String> receiptList = new ArrayList<>();

    public void generateBill(ArrayList<Product> allTheProductsInTheBasket) {

        Iterator<Product> productIterator = allTheProductsInTheBasket
                .iterator();

        while (productIterator.hasNext()) {

            Product currentProduct = productIterator.next();

            double taxAppliedPrice = currentProduct.getTaxAppliedPrice();
            taxAppliedPrice = Math.ceil(taxAppliedPrice * 100.0) / 100.0;
            receiptList.add(currentProduct.getQuantity() + " " + currentProduct
                    .getProductDescription() + " - " + String.format("%.2f",
                    taxAppliedPrice));
            billAmount += Math.ceil(currentProduct.getTaxAppliedPrice() * 100.0) / 100.0;
            salesTax += Math.ceil(currentProduct.getTax() * 100.0) / 100.0;
        }

        receiptList.add(SALES_TAXES + String.format("%.2f", salesTax));
        receiptList.add(TOTAL + String.format("%.2f", billAmount));
    }

    public double getBillAmount() {
        return billAmount;
    }

    public double getSalesTaxAmount() {
        return salesTax;
    }

    public ArrayList<String> printReceipt() {
        Iterator<String> receiptIterator = receiptList.iterator();
        while (receiptIterator.hasNext()) {
            System.out.println(receiptIterator.next());
        }
        return receiptList;
    }
}
