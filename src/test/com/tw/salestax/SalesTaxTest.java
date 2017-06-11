package com.tw.salestax;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SalesTaxTest {

    private String[] shoppingBasketOne = {"1 imported toy at 12.49"};
    private String[] shoppingBasketTwo = {"1 book at 12.49",
            "1 music CD at 14.99",
            "1 chocolate bar at 0.85"};
    @Before
    public void setUp() {
        ProductCategorizer productCategorizer = new ProductCategorizer();
        productCategorizer.clearMapEntries();
    }

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
    public void shouldCategorizeTheProductAsImportedAndTaxExempted() {
        Product product = new Product(1,"imported toy", 16.22);
        ProductCategorizer productCategorizer = new ProductCategorizer();
        productCategorizer.categorizeProduct(product);
        assertTrue(productCategorizer.taxAssociatedWithAProduct() instanceof ImportationAndSalesTax);
    }

    @Test
    public void shouldCategorizeTheProductAsSalesTaxApplicable() {
        Product product = new Product(1,"toy", 16.22);
        ProductCategorizer productCategorizer = new ProductCategorizer();
        productCategorizer.categorizeProduct(product);
        assertTrue(productCategorizer.taxAssociatedWithAProduct() instanceof SalesTax);
    }

    @Test
    public void shouldCategorizeTheProductAsImportationTaxApplicable() {
        Product product = new Product(1,"imported chocolate", 16.22);
        ProductCategorizer productCategorizer = new ProductCategorizer();
        productCategorizer.categorizeProduct(product);
        assertTrue(productCategorizer.taxAssociatedWithAProduct() instanceof ImportationTax);
    }

    @Test
    public void shouldCategorizeTheProductAsTaxExempted() {
        Product product = new Product(1,"book", 12.45);
        ProductCategorizer productCategorizer = new ProductCategorizer();
        productCategorizer.categorizeProduct(product);
        assertTrue(productCategorizer.taxAssociatedWithAProduct() instanceof ExemptedProduct);
    }

    @Test
    public void shouldReturnTheBillAmount() {
        ProductParser productParser = new ProductParser(shoppingBasketTwo);
        ProductCategorizer productCategorizer = new ProductCategorizer();
        BillGenerator billGenerator = new BillGenerator();
        billGenerator.generateBill(productCategorizer.getAllTheProductsInTheBasket());
        assertEquals(29.83, billGenerator.getBillAmount(),0);
        assertEquals(1.5, billGenerator.getSalesTaxAmount(),0);
    }

}
