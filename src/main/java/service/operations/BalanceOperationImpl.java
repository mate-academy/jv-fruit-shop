package service.operations;

import db.Storage;
import model.FruitTransaction;
import service.OperationHandle;

public class BalanceOperationImpl implements OperationHandle {
    @Override
    public void operation(FruitTransaction fruitTransaction) {
        Storage.fruits.put(fruitTransaction.getFruitName(), fruitTransaction.getQuantity());
    }
}
