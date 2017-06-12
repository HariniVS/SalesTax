package com.tw.salestax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SalesTaxMain {
    public static void main(String[] args) {

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        List<String> productsPurchased = new ArrayList<String>();
        try {
            String input = bufferedReader.readLine();
            while (input.length() > 0) {
                productsPurchased.add(input);
                input = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] productsToBeParsed = new String[productsPurchased.size()];
        productsToBeParsed = productsPurchased.toArray(productsToBeParsed);
        new ProductParser(productsToBeParsed);
        ProductCategorizer productCategorizer = new ProductCategorizer();
        BillGenerator billGenerator = new BillGenerator();
        billGenerator.generateBill(productCategorizer.getAllTheProductsInTheBasket());
        billGenerator.printReceipt();
    }
}
