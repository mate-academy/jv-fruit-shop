package service.operations;

import db.Storage;
import model.FruitTransaction;
import service.OperationHandle;

public class SupplyOperationImpl implements OperationHandle {
    @Override
    public void operation(FruitTransaction fruitTransaction) {
        Storage.fruits.put(fruitTransaction.getFruitName(),
                Storage.fruits.get(fruitTransaction.getFruitName())
                        + fruitTransaction.getQuantity());
    }
}
