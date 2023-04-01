package service.operation;

import db.Storage;
import model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void operation(FruitTransaction transaction) {
        Storage.fruits.put(transaction.getFruitName(), transaction.getQuantity());
    }
}
