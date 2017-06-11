package com.tw.salestax;

import org.junit.Test;

import static org.junit.Assert.*;

public class SalesTaxTest {

    private String[] shoppingBasketOne = {"2 book at 12.49"};
    private String[] shoppingBasketTwo = {"1 music CD at 14.99"};
    @Test
    public void checkIfShoppingBasketIsNotNull() {
        assertNotNull(shoppingBasketOne);
    }

    @Test
    public void shouldReturnQuantityAndPrice() {
        ProductParser productParser = new ProductParser(shoppingBasketOne);
        Product[] product = productParser.getAllProductsInBasket();
        assertEquals(12.49, product[0].getPrice(), 0);
    }

    @Test
    public void shouldReturnNoTaxes() {
        ProductParser productParser = new ProductParser(shoppingBasketOne);
        Product product = new Product(productParser.getQuantity(), productParser.getProduct(), productParser.getPrice());
        ProductCategorizer productCategorizer = new ProductCategorizer();
        productCategorizer.categorizeAllProducts(product);
        assertNull(productCategorizer.taxAssociatedWithAProduct());
    }

    @Test
    public void shouldReturnTheTaxesAssociated() {
        ProductParser productParser = new ProductParser(shoppingBasketTwo);
        ProductCategorizer productCategorizer = new ProductCategorizer();
        productCategorizer.categorizeAllProducts(product);
        assertEquals(new SalesTax(), productCategorizer.taxAssociatedWithAProduct());
    }

}
