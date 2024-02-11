package core.basesyntax.service.impl;

import core.basesyntax.service.TransactionService;

public class PurchaseTransactionService implements TransactionService {
    @Override
    public int executeTransaction(int quantity, int count) {
        int afterSale = quantity - count;
        if (afterSale < 0) {
            throw new RuntimeException("Invalid transaction:"
                    + " quantity cannot be negative after purchase");
        }
        return afterSale;
    }
}
