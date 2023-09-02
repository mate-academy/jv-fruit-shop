package service.impl;

import db.Storage;
import model.FruitTransaction;
import service.operation.OperationTransaction;

public class PurchaseOperationTransactionImpl implements OperationTransaction {
    @Override
    public void fruitOperation(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruit();
        int fruitQuantity = fruitTransaction.getQuantity();
        if (Storage.storageFruit.containsKey(fruitName)) {
            int updateQuantityFruit = Storage.storageFruit.get(fruitName) - fruitQuantity;
            if (updateQuantityFruit < 0) {
                throw new RuntimeException("We don't have enough fruits: " + fruitName);
            }
            Storage.storageFruit.replace(fruitName, updateQuantityFruit);
        }
    }
}
