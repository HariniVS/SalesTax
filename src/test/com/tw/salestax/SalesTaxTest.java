package com.tw.salestax;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SalesTaxTest {

    private String[] shoppingBasketOne = {"2 book at 12.49"};
    private String[] shoppingBasketTwo = {"1 book at 12.49",
            "1 music CD at 14.99",
            "1 chocolate bar at 0.85"};

    @Test
    public void checkIfShoppingBasketIsNotNull() {
        assertNotNull(shoppingBasketOne);
    }

    @Test
    public void shouldReturnQuantityProductAndPrice() {
        ProductParser productParser = new ProductParser(shoppingBasketOne);
        assertEquals(12.49, productParser.getPrice(), 0);
        assertEquals(2, productParser.getQuantity());
        assertEquals("2 book at 12.49", productParser.getProduct());

    }
    
}
