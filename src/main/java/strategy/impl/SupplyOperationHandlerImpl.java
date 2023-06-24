package strategy.impl;

import db.FruitStorage;
import fruitscontent.FruitTransaction;
import strategy.OperationHandler;

public class SupplyOperationHandlerImpl implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        int oldQuantity = FruitStorage.fruits.get(transaction.getFruit());
        FruitStorage.fruits.put(transaction.getFruit(), oldQuantity + transaction.getQuantity());
    }
}
