package service.operations;

import db.Storage;
import model.FruitTransaction;
import service.OperationHandle;

public class PurchaseOperationImpl implements OperationHandle {
    @Override
    public void operation(FruitTransaction fruitTransaction) {
        Integer lastSumm = Storage.fruits.get(fruitTransaction.getFruitName());
        Storage.fruits.put(fruitTransaction.getFruitName(),
                lastSumm - fruitTransaction.getQuantity());
    }
}
