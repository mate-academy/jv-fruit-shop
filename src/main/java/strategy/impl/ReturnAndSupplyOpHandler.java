package strategy.impl;

import core.basesyntax.FruitTransaction;
import db.Storage;
import strategy.OperationHandler;

public class ReturnAndSupplyOpHandler implements OperationHandler {
    @Override
    public void handler(FruitTransaction fruitTransaction, Storage storage) {
        if (fruitTransaction.getFruit() == null) {
            throw new IllegalArgumentException("Fruit is null or quantity is less  than 0");
        }
        storage.add(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
