package service.impl;

import db.Storage;
import model.FruitTransaction;
import service.operation.OperationTransaction;

public class BalanceOperationTransactionImpl implements OperationTransaction {
    @Override
    public void fruitOperation(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruit();
        int fruitQuantity = fruitTransaction.getQuantity();
        if (fruitTransaction.getQuantity() < 0) {
            throw new RuntimeException("Incorrect balance's quantity"
                    + fruitTransaction.getQuantity());
        }
        Storage.getStorageFruit().put(fruitName, fruitQuantity);
    }
}
