package strategy.impl;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class BalanceOperationImpl implements OperationHandler {
    @Override
    public void operation(FruitTransaction fruitTransaction) {
        Storage.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
