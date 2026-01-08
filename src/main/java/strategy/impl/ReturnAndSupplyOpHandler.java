package strategy.impl;

import core.basesyntax.FruitTransaction;
import db.Storage;
import strategy.OperationHandler;

public class ReturnAndSupplyOpHandler implements OperationHandler {
    @Override
    public void handler(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getFruit() == null || fruitTransaction.getQuantity() < 0) {
            throw new IllegalArgumentException("Fruit is null or quantity is less  than 0");
        }
        int currentQuantity = Storage.fruitStorage.getOrDefault(fruitTransaction.getFruit(), 0);
        Storage.fruitStorage
                .put(fruitTransaction.getFruit(), currentQuantity + fruitTransaction.getQuantity());
    }
}
