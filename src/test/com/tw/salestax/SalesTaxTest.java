package com.tw.salestax;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SalesTaxTest {

    private String[] shoppingBasketOne = {"1 imported toy at 12.49"};
    private String[] shoppingBasketTwo = {"1 book at 12.49",
            "1 music CD at 14.99",
            "1 chocolate bar at 0.85"};

    @Test
    public void shouldReturnListParsedProducts() {
        ProductParser productParser = new ProductParser(shoppingBasketOne);
        List<Product> product = productParser.getAllProductsInBasket();
        List<Product> expectedProducts = new ArrayList<>();
        expectedProducts.add(new Product(1, "imported toy", 12.49));
        assertEquals(expectedProducts, product);
    }

    @Test
    public void shouldReturnTheTotalAmount() {
        ProductParser productParser = new ProductParser(shoppingBasketTwo);
        ProductCategorizer productCategorizer = new ProductCategorizer();
        BillGenerator billGenerator = new BillGenerator();
        billGenerator.generateBill(productParser.getAllProductsInBasket());
        assertEquals(29.83, billGenerator.getBillAmount(), 0);
    }

    @Test
    public void shouldReturnTheSalesTax() {
        ProductParser productParser = new ProductParser(shoppingBasketTwo);
        ProductCategorizer productCategorizer = new ProductCategorizer();
        BillGenerator billGenerator = new BillGenerator();
        billGenerator.generateBill(productParser.getAllProductsInBasket());
        assertEquals(1.5, billGenerator.getSalesTaxAmount(), 0);
    }

    @Test
    public void shouldPrintReceipt() {
        List<String> expectedReceipt = Arrays.asList(
                "1 book - 12.49",
                "1 music CD - 16.49",
                "1 chocolate bar - 0.85",
                "Sales Taxes - 1.50",
                "Total - 29.83");
        ProductParser productParser = new ProductParser(shoppingBasketTwo);
        ProductCategorizer productCategorizer = new ProductCategorizer();
        BillGenerator billGenerator = new BillGenerator();
        billGenerator.generateBill(productParser.getAllProductsInBasket());
        assertEquals(expectedReceipt, billGenerator.printReceipt());
    }
}
