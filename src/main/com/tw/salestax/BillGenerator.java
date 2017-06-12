package com.tw.salestax;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BillGenerator {

    public static final String TOTAL = "Total - ";
    public static final String SALES_TAXES = "Sales Taxes - ";
    private double billAmount = 0.0;
    private double salesTax = 0.0;
    private List<String> receiptList = new ArrayList<>();
    private  Receipt receipt;

    public void generateBill(Map<Product, Tax> allTheProductsInTheBasket) {
        for (Map.Entry<Product, Tax> mapEntry : allTheProductsInTheBasket.entrySet()) {
            Product product = mapEntry.getKey();
            Tax taxValue = mapEntry.getValue();
            double taxAppliedPrice = (taxValue.applyTax() * product.getPrice() + product.getPrice());
            billAmount = billAmount + (double)(taxAppliedPrice * product.getQuantity());
            if (taxValue instanceof SalesTax) {
                salesTax += taxAppliedPrice - product.getPrice();
            }
            receiptList.add(product.getQuantity()+" "+product.getProductDescription()+"- "+product.getPrice());
        }
        billAmount = Math.ceil(billAmount * 100.0) / 100.0;
        receiptList.add(TOTAL +billAmount);
        salesTax = Math.ceil(salesTax * 100.0) / 100.0;
        receiptList.add(SALES_TAXES +salesTax);
    }

    public double getBillAmount() {
        return billAmount;
    }

    public double getSalesTaxAmount() {
        return salesTax;
    }

    public void printReceipt() {
        receipt = new Receipt(receiptList);
    }
}
