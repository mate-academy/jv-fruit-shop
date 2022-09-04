package strategy;

import db.Storage;
import model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public int operationHandle(FruitTransaction fruitTransaction) {
        Storage.storage.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        return fruitTransaction.getQuantity();
    }
}
