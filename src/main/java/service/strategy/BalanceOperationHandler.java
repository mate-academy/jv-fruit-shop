package service.strategy;

import db.Storage;
import model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {

    @Override
    public void operate(FruitTransaction transaction) {
        Storage.fruits.put(transaction.getFruit(), transaction.getQuantity());
    }
}
