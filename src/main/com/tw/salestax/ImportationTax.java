package com.tw.salestax;

public class ImportationTax implements Tax {

    double importationTax = 0.05;

    @Override
    public double getTaxPercentageFactor() {
        return importationTax;
    }
}
