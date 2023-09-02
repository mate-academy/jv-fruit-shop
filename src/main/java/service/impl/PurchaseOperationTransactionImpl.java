package service.impl;

import db.Storage;
import model.FruitTransaction;
import service.operation.OperationTransaction;

public class PurchaseOperationTransactionImpl implements OperationTransaction {
    @Override
    public void fruitOperation(FruitTransaction fruitTransaction) {
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
