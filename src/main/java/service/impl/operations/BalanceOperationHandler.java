package service.impl.operations;

import db.Storage;
import service.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void performOperation(String fruit, int amount) {
        Storage.setFruitBalance(fruit, amount);
    }
}
