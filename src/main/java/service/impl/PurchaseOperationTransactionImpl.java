package service.impl;

import db.Storage;
import model.FruitTransaction;
import service.operation.TransactionHandler;

public class PurchaseOperationTransactionImpl implements TransactionHandler {
    @Override
    public void handleTransaction(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruit();
        int fruitQuantity = fruitTransaction.getQuantity();
        if (Storage.getStorageFruit().containsKey(fruitName)) {
            int updateQuantityFruit = Storage.getStorageFruit().get(fruitName) - fruitQuantity;
            if (updateQuantityFruit < 0) {
                throw new RuntimeException("We don't have enough fruits: " + fruitName);
            }
            Storage.getStorageFruit().replace(fruitName, updateQuantityFruit);
        }
    }
}
