package service.operation;

import db.Storage;
import models.FruitTransaction;

public class BalanceHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Storage.fruitMap.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
