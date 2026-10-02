package service.operation;

import db.Storage;
import model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        Storage.fruits.put(transaction.getFruit(), transaction.getQuantity());
    }
}
