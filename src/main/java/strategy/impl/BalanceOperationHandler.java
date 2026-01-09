package strategy.impl;

import core.basesyntax.FruitTransaction;
import db.Storage;
import strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {

    @Override
    public void handler(FruitTransaction fruitTransaction, Storage storage) {
        if (fruitTransaction.getFruit() == null || fruitTransaction.getQuantity() < 0) {
            throw new IllegalArgumentException("Fruit is null or quantity is less  than 0");
        }
        storage.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
