package service.impl;

import db.Storage;
import model.FruitTransaction;
import service.operation.OperationTransaction;

public class SupplyOperationTransactionImpl implements OperationTransaction {
    @Override
    public void fruitOperation(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruit();
        int fruitQuantity = fruitTransaction.getQuantity();
        if (Storage.storage.containsKey(fruitName)) {
            int updateQuantityFruit = Storage.storage.get(fruitName) + fruitQuantity;
            Storage.storage.replace(fruitName, updateQuantityFruit);
        }
    }
}
