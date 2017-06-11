package com.tw.salestax;

import java.util.HashMap;
import java.util.Map;

public class ProductCategorizer {

    private String[] taxExemptedItems = {"book", "medicine", "chocolate", "food"};
    private static Map<Product, Tax> productTaxMap = new HashMap<>();
    private Product product;

    public void categorizeProduct(Product product) {
        this.product = product;
        String productDescription = product.getProductDescription();
        if (isImportedProduct(productDescription) && !(isTaxExemptedProduct(productDescription))) {
            productTaxMap.put(product, new ImportationAndSalesTax());
        } else if (isImportedProduct(productDescription)) {
            productTaxMap.put(product, new ImportationTax());
        } else if (!isTaxExemptedProduct(productDescription)) {
            productTaxMap.put(product, new SalesTax());
        } else {
            productTaxMap.put(product, new ExemptedProduct());
        }
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

    public Tax taxAssociatedWithAProduct() {
        return productTaxMap.get(product);
    }

    public Map<Product, Tax> getAllTheProductsInTheBasket() {
        return productTaxMap;
    }

    public void clearMapEntries() {
        productTaxMap.clear();
    }
}