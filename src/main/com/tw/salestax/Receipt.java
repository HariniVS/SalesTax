package com.tw.salestax;

import java.util.Iterator;
import java.util.List;

public class Receipt {

    private final List<String> receipt;

    public Receipt(List<String> receiptList) {
        this.receipt = receiptList;
        printReceipt();
    }

    public void printReceipt() {
        Iterator<String> receiptIterator = receipt.iterator();
        while (receiptIterator.hasNext()) {
            System.out.println(receiptIterator.next());
        }
    }

    public List<String> getReceipt() {
        return receipt;
    }
}
