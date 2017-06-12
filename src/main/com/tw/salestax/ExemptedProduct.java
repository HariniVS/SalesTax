package com.tw.salestax;

public class ExemptedProduct implements Tax {

    @Override
    public double getTaxPercentageFactor() {
        return 0;
    }
}
