package servise.transaction.impl;

import db.Storage;
import servise.transaction.TransactionHandler;

public class BalanceTransactionHandler implements TransactionHandler {
    @Override
    public void proceedTransaction(String item, int quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Can't install negative balance for " + item);
        }

        Storage.items.put(item, quantity);
    }
}
