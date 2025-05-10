package strategy.impl;

import db.FruitsStorage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class BalanceOperationHandlerImpl implements OperationHandler {

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        FruitsStorage.fruitsStorage.put(fruitTransaction.getName(), fruitTransaction.getQuantity());
    }
}
