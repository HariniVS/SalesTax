package com.tw.salestax;

public class ProductCategorizer {

    private String[] taxExemptedItems = {"book", "medicine", "chocolate", "food"};
    private Product product;

    public Tax categorizeProduct(Product product) {
        this.product = product;

        String productDescription = product.getProductDescription();

        if (isImportedProduct(productDescription) && !(isTaxExemptedProduct(productDescription))) {
            return new ImportationAndSalesTax();
        }
        if (isImportedProduct(productDescription)) {
            return new ImportationTax();
        }
        if (!isTaxExemptedProduct(productDescription)) {
            return new SalesTax();
        }
        return new ExemptedProduct();
    }

    private boolean isTaxExemptedProduct(String productDescription) {
        for (String taxExemptedItem : taxExemptedItems) {
            if (productDescription.contains(taxExemptedItem))
                return true;
        }
        return false;
    }

    private boolean isImportedProduct(String productDescription) {
        return productDescription.contains("imported");
    }
}