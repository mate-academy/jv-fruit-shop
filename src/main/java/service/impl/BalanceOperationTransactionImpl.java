package service.impl;

import db.Storage;
import model.FruitTransaction;
import service.operation.TransactionHandler;

public class BalanceOperationTransactionImpl implements TransactionHandler {
    @Override
    public void handleTransaction(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruit();
        int fruitQuantity = fruitTransaction.getQuantity();
        if (fruitTransaction.getQuantity() < 0) {
            throw new RuntimeException("Incorrect balance's quantity"
                    + fruitTransaction.getQuantity());
        }
        Storage.getStorageFruit().put(fruitName, fruitQuantity);
    }
}
