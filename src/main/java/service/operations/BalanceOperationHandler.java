package service.operations;

import db.Storage;
import model.FruitTransaction;
import service.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Storage.fruits.put(fruitTransaction.getFruitName(), fruitTransaction.getQuantity());
    }
}
