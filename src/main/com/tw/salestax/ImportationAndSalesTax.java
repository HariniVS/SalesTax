package com.tw.salestax;

public class ImportationAndSalesTax implements Tax {

    double importationAndSalesTax = 0.15;

    @Override
    public double getTaxPercentageFactor() {
        return importationAndSalesTax;
    }
}
