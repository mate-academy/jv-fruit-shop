package service.operation;

import db.Storage;
import model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void getOperation(FruitTransaction transaction) {
        if (transaction.getQuantity() >= 0) {
            Storage.fruits.put(transaction.getFruitName(), transaction.getQuantity());
        } else {
            throw new RuntimeException("Quantity is less than 0");
        }
    }
}
