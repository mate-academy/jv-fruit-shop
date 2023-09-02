package service.impl;

import db.Storage;
import model.FruitTransaction;
import service.operation.OperationTransaction;

public class SupplyOperationTransactionImpl implements OperationTransaction {
    @Override
    public void fruitOperation(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruit();
        int fruitQuantity = fruitTransaction.getQuantity();
        if (Storage.storageFruit.containsKey(fruitName)) {
            int updateQuantityFruit = Storage.storageFruit.get(fruitName) + fruitQuantity;
            Storage.storageFruit.replace(fruitName, updateQuantityFruit);
        }
    }
}
