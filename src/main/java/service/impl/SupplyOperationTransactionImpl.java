package service.impl;

import db.Storage;
import model.FruitTransaction;
import service.operation.OperationTransaction;

public class SupplyOperationTransactionImpl implements OperationTransaction {
    @Override
    public void fruitOperation(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruit();
        int fruitQuantity = fruitTransaction.getQuantity();
        if (Storage.getStorageFruit().containsKey(fruitName)) {
            int updateQuantityFruit = Storage.getStorageFruit().get(fruitName) + fruitQuantity;
            Storage.getStorageFruit().replace(fruitName, updateQuantityFruit);
        }
    }
}
