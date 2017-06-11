package com.tw.salestax;

public class ExemptedProduct implements Tax {

    @Override
    public double applyTax() {
        return 0;
    }
}
