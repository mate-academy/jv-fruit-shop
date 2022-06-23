package servise.transaction.impl;

import db.Storage;
import servise.transaction.TransactionHandler;

public class SupplyTransactionHandler implements TransactionHandler {
    @Override
    public void proceedTransaction(String item, int quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Can't return negative quantity of " + item);
        }
        int quantityBeforeTransaction = Storage.items.getOrDefault(item, 0);

        Storage.items.put(item, quantityBeforeTransaction + quantity);
    }
}
