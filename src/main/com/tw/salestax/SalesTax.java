package com.tw.salestax;

public class SalesTax implements Tax {

    double salesTax = 0.10;

    @Override
    public double applyTax() {
        return salesTax;
    }
}
