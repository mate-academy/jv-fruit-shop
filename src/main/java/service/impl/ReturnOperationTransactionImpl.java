package service.impl;

import db.Storage;
import model.FruitTransaction;
import service.operation.TransactionHandler;

public class ReturnOperationTransactionImpl implements TransactionHandler {
    @Override
    public void handleTransaction(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruit();
        int fruitQuantity = fruitTransaction.getQuantity();
        if (Storage.getStorageFruit().containsKey(fruitName)) {
            int updateQuantityFruit = Storage.getStorageFruit().get(fruitName) + fruitQuantity;
            Storage.getStorageFruit().replace(fruitName,updateQuantityFruit);
        }
    }
}
